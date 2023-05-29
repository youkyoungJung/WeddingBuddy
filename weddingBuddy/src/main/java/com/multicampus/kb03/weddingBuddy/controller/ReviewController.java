package com.multicampus.kb03.weddingBuddy.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

import com.multicampus.kb03.weddingBuddy.service.PlannerService;

@Controller
@RequestMapping("/")
public class ReviewController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private PlannerService plannerService;

	@GetMapping("/review")
	public String ReviewGet(Model model, @RequestParam("planner_id") String planner_id,
			@RequestParam("user_id") int user_id) throws Exception {
		logger.info("parameter에 있는 user_id: " + user_id);
		logger.info("parameter에 있는 planner_id: " + planner_id);
		model.addAttribute("user_id", user_id);
		model.addAttribute("planner_id", planner_id);
		return "review";
	}

	@PostMapping("/review")
	public String reviewPost(@RequestParam("user_id") int userId, @RequestParam("planner_id") int plannerId,
	        @RequestParam("formFileMultiple") MultipartFile[] imageFiles, @RequestParam("content") String content, Model model) {

	    try {
	        Planner_Review reviewData = new Planner_Review();
	        reviewData.setUser_id(userId);
	        reviewData.setPlanner_id(plannerId);
	        reviewData.setContent(content);

	        int reviewResult = plannerService.saveReview(reviewData);

	        if (reviewResult > 0) {
	            logger.info("리뷰 정보가 성공적으로 저장되었습니다.");
	            int reviewId = reviewData.getReview_id();
	            logger.info("review_id: " + reviewId);

	            List<String> imageNames = new ArrayList<>();
	            for (MultipartFile imageFile : imageFiles) {
	                if (!imageFile.isEmpty()) {
	                    String fileName = generateUniqueFileName(imageFile.getOriginalFilename());
	                    String uploadDirectory = "/Users/jeongeunlee/git/WeddingBuddy/weddingBuddy/src/main/resources/static/review_images";
	                    File destFile = new File(uploadDirectory + "/" + fileName);

	                    destFile.createNewFile();
	                    System.out.println("파일 업로드 성공");

	                    imageFile.transferTo(destFile);

	                    Review_Image imageData = new Review_Image();
	                    imageData.setReview_id(reviewId);
	                    imageData.setImage(uploadDirectory + "/" + fileName);

	                    int imageResult = plannerService.saveReviewImage(imageData);

	                    if (imageResult > 0) {
	                        logger.info("리뷰 이미지 정보가 성공적으로 저장되었습니다.");
	                        // 이미지 파일 이름 추가
	                        imageNames.add(fileName);
	                    } else {
	                        logger.info("리뷰 이미지 정보 저장에 실패했습니다.");
	                    }
	                }
	            }

	            // 이미지 파일 이름들을 Model 객체에 추가
	            model.addAttribute("imageNames", imageNames);

	            return "redirect:/review/detail?planner_id=" + plannerId;
	        } else {
	            logger.info("리뷰 정보 저장에 실패했습니다.");
	        }
	    } catch (Exception e) {
	        logger.error("리뷰 저장 과정에서 오류가 발생했습니다: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return "review";
	}


	private String generateUniqueFileName(String originalFileName) {
		// 고유한 파일 이름 생성 로직 구현
		// 예시: 타임스탬프 + 원본 파일 이름
		String timestamp = String.valueOf(System.currentTimeMillis());
		return timestamp + "_" + originalFileName;
	}

	@GetMapping("/review/detail")
	public String reviewDetail(@RequestParam("planner_id") int plannerId, Model model) {
	    try {
	        List<Planner_Review> reviewList = plannerService.getReviewDetail(plannerId);

	        // 리뷰 이미지 정보를 가져오기 위해 Review_Image 클래스 대신 Map<String, String> 형태로 변경합니다.
	        List<Map<String, String>> reviewImagesList = new ArrayList<>();

	        // user_id와 name의 매핑 정보를 가진 Map을 생성합니다.
	        Map<Integer, String> userAccountMap = new HashMap<>();

	        for (Planner_Review review : reviewList) {
	            // user_id를 키로하여 user_account에서 name 값을 가져옵니다.
	            String name = plannerService.getUserAccountName(review.getUser_id());
	            userAccountMap.put(review.getUser_id(), name);

	            List<Review_Image> reviewImages = plannerService.getReviewImages(review.getReview_id());

	            for (Review_Image reviewImage : reviewImages) {
	                // 리뷰 이미지의 review_id와 image를 Map 형태로 변환하여 리스트에 추가합니다.
	                Map<String, String> reviewImageMap = new HashMap<>();
	                reviewImageMap.put("review_id", String.valueOf(reviewImage.getReview_id()));
	                String imagePath = reviewImage.getImage();
	                String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7); // "/static" 이후의 부분만 가져옴
	                reviewImageMap.put("image", trimmedImagePath);
	                reviewImagesList.add(reviewImageMap);
	                logger.info("reviewImageMap : "+ reviewImageMap);
	            }
	        }

	        model.addAttribute("reviewList", reviewList);
	        model.addAttribute("reviewImagesList", reviewImagesList);
	        model.addAttribute("userAccountMap", userAccountMap); // user_id와 name의 매핑 정보를 모델에 추가합니다.

	        return "review_detail";
	    } catch (Exception e) {
	        logger.error("리뷰 상세 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return "error"; // 오류 발생 시 error 페이지로 이동하도록 수정해야 함
	}


}