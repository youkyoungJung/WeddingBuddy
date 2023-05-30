package com.multicampus.kb03.weddingBuddy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.kb03.weddingBuddy.dto.Beauty_Salon;
import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.Beauty_SalonService;
import com.multicampus.kb03.weddingBuddy.service.DressService;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;


@Controller
@RequestMapping("/")
public class Beauty_SalonController {
	
	@Autowired
	private Beauty_SalonService beauty_SalonService;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Beauty_SalonController.class);

	@GetMapping("/beauty_Salon")
	public String findBeauty_SalonGet(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception { 
		try {
			//드레스 샵 정보 가져오기 
			List<Beauty_Salon> beauty_Salons = beauty_SalonService.getAllBeauty_Salon();

			//드레스 이미지 가져오기 
			List<Map<String, String>> beauty_SalonImagesList = new ArrayList<>();

			// 드레스 이미지의 company_unique_id 랑 image를 map 형태로 변환하여 리스트에 추가
			for (Beauty_Salon beauty_Salon : beauty_Salons) {
				logger.info("unique_key: " + beauty_Salon.getCompany_unique_id());
				List<Company_Image> companyImages = beauty_SalonService.getCompanyImages(beauty_Salon.getCompany_unique_id());
				logger.info("companyImages : " + companyImages);

				for (Company_Image companyImage : companyImages) {
					Map<String, String> companyImageMap = new HashMap<>();
					companyImageMap.put("company_unique_id", String.valueOf(companyImage.getCompany_unique_id()));
					String imagePath = companyImage.getImage();
					String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7);
					companyImageMap.put("image", trimmedImagePath);
					beauty_SalonImagesList.add(companyImageMap);
				}
				logger.info("beauty_SalonImagesList : " + beauty_SalonImagesList);
			}

			model.addAttribute("beauty_Salons", beauty_Salons);
			model.addAttribute("beauty_SalonImagesList", beauty_SalonImagesList);
			logger.info("beauty_Salons : " + beauty_Salons);
			return "beauty_Salon";
		} catch (Exception e) {
			logger.error("메이크업 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		return "error";
    }
	@GetMapping("/beauty_Salon_detail")
	public String findDressDetail(@RequestParam("beauty_salon_id") int beauty_salon_id, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			// Dress_Shop 정보 가져오기
			Beauty_Salon beauty_Salon = beauty_SalonService.getBeauty_SalonById(beauty_salon_id);
			model.addAttribute("beauty_Salon", beauty_Salon);
			
			List<String> beauty_SalonImagesList = new ArrayList<>();
			
			// Company_Image 정보 가져오기
			List<Company_Image> companyImages = beauty_SalonService.getImagesByShopId(beauty_salon_id);
			for (Company_Image companyImage : companyImages) {
				String imagePath = companyImage.getImage();
				String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7);
				beauty_SalonImagesList.add(trimmedImagePath);
			}
			
			logger.info("beauty_SalonImagesList : "+beauty_SalonImagesList);
			model.addAttribute("beauty_SalonImagesList", beauty_SalonImagesList);

			return "beauty_Salon_detail";
		} catch (Exception e) {
			logger.error("메이크업 상세 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		return "error";
	}
        
}
