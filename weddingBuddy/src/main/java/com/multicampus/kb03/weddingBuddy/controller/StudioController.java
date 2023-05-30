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

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Studio;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.DressService;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.StudioService;
import com.multicampus.kb03.weddingBuddy.service.UserService;


@Controller
@RequestMapping("/")
public class StudioController {
	
	@Autowired
	private StudioService studioService;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StudioController.class);

	@GetMapping("/studio")
	public String findStudioGet(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception { 
		try {
			//드레스 샵 정보 가져오기 
			List<Studio> studios = studioService.getAllStudioShops();

			//드레스 이미지 가져오기 
			List<Map<String, String>> studioImagesList = new ArrayList<>();

			// 드레스 이미지의 company_unique_id 랑 image를 map 형태로 변환하여 리스트에 추가
			for (Studio studio : studios) {
				logger.info("unique_key: " + studio.getCompany_unique_id());
				List<Company_Image> companyImages = studioService.getCompanyImages(studio.getCompany_unique_id());
				logger.info("companyImages : " + companyImages);

				for (Company_Image companyImage : companyImages) {
					Map<String, String> companyImageMap = new HashMap<>();
					companyImageMap.put("company_unique_id", String.valueOf(companyImage.getCompany_unique_id()));
					String imagePath = companyImage.getImage();
					String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7);
					companyImageMap.put("image", trimmedImagePath);
					studioImagesList.add(companyImageMap);
				}
				logger.info("studioImagesList : " + studioImagesList);
			}

			model.addAttribute("studios", studios);
			model.addAttribute("studioImagesList", studioImagesList);
			logger.info("studios : " + studios);
			return "studio";
		} catch (Exception e) {
			logger.error("스튜디오 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		return "error";
    }
	@GetMapping("/studio_detail")
	public String findStudioDetail(@RequestParam("studio_id") int studio_id, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			// Dress_Shop 정보 가져오기
			Studio studio = studioService.getStudioById(studio_id);
			model.addAttribute("studio", studio);
			
			List<String> studioImagesList = new ArrayList<>();
			
			// Company_Image 정보 가져오기
			List<Company_Image> companyImages = studioService.getImagesByShopId(studio_id);
			for (Company_Image companyImage : companyImages) {
				String imagePath = companyImage.getImage();
				String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7);
				studioImagesList.add(trimmedImagePath);
			}
			
			logger.info("studioImagesList : "+studioImagesList);
			model.addAttribute("studioImagesList", studioImagesList);

			return "studio_detail";
		} catch (Exception e) {
			logger.error("스튜디오 상세 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		return "error";
	}
        
}
