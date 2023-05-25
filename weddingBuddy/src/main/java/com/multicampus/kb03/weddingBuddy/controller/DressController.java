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
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.DressService;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;


@Controller
@RequestMapping("/")
public class DressController {
	
	@Autowired
	private DressService dressService;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DressController.class);

	@GetMapping("/dress")
	public String findDressGet(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception { 
		try {
			//드레스 샵 정보 가져오기 
			List<Dress_Shop> dressShops = dressService.getAllDressShops();

			//드레스 이미지 가져오기 
			List<Map<String, String>> dressImagesList = new ArrayList<>();

			// 드레스 이미지의 company_unique_id 랑 image를 map 형태로 변환하여 리스트에 추가
			for (Dress_Shop dressShop : dressShops) {
				logger.info("unique_key: " + dressShop.getCompany_unique_id());
				List<Company_Image> companyImages = dressService.getCompanyImages(dressShop.getCompany_unique_id());
				logger.info("companyImages : " + companyImages);

				for (Company_Image companyImage : companyImages) {
					Map<String, String> companyImageMap = new HashMap<>();
					companyImageMap.put("company_unique_id", String.valueOf(companyImage.getCompany_unique_id()));
					String imagePath = companyImage.getImage();
					String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7);
					companyImageMap.put("image", trimmedImagePath);
					dressImagesList.add(companyImageMap);
				}
				logger.info("dressImagesList : " + dressImagesList);
			}

			model.addAttribute("dressShops", dressShops);
			model.addAttribute("dressImagesList", dressImagesList);
			logger.info("dressShop : " + dressShops);
			return "dress";
		} catch (Exception e) {
			logger.error("드레스 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		return "error";
    }
	@GetMapping("/dress_detail")
	public String findDressDetail(@RequestParam("dress_shop_id") int dress_shop_id,Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("dress_shop_id",dress_shop_id);
		logger.info("dress_shop_id :"+dress_shop_id);
		return "dress_detail"; 
	}
        
}
