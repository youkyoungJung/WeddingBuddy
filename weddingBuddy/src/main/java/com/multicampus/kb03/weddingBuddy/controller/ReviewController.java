package com.multicampus.kb03.weddingBuddy.controller;



import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String ReviewGet(Model model, @RequestParam("planner_id") String planner_id, @RequestParam("user_id") int user_id) throws Exception {
	    logger.info("parameter에 있는 user_id: " + user_id);
	    logger.info("parameter에 있는 planner_id: " + planner_id);
	    model.addAttribute("user_id", user_id);
	    model.addAttribute("planner_id", planner_id);
	    return "review";
	}


	@PostMapping("/review")
	public String reviewPost(
	    @RequestParam("user_id") int userId, 
	    @RequestParam("planner_id") int plannerId, 
	    @RequestParam("formFileMultiple") MultipartFile[] imageFiles,
	    @RequestParam("content") String content) {

	    try {
	        Planner_Review reviewData = new Planner_Review();
	        reviewData.setUser_id(userId);
	        reviewData.setPlanner_id(plannerId);
	        reviewData.setContent(content);

	        int reviewResult = plannerService.saveReview(reviewData);

	        if (reviewResult > 0) {
	            logger.info("리뷰 정보가 성공적으로 저장되었습니다.");
	            //review_id 반환 
	            int reviewId = reviewData.getReview_id();
	            logger.info("review_id : "+reviewId);
	            // 이미지 파일 저장
	            for (MultipartFile imageFile : imageFiles) {
	                if (!imageFile.isEmpty()) {
	                    String fileName = generateUniqueFileName(imageFile.getOriginalFilename());
	                    String uploadDirectory = "/Users/jeongeunlee/git/WeddingBuddy/weddingBuddy/src/main/resources/static/review_images";
	                    File destFile = new File(uploadDirectory +"//"+ fileName);
	                    
	                    //if(destFile.getParentFile().mkdirs()) {
	                    	destFile.createNewFile();
	                    	System.out.println("파일 업로드 성공");
	                    //}
	                    
	                    imageFile.transferTo(destFile);
	                    
	                    Review_Image imageData = new Review_Image();
	                    imageData.setReview_id(reviewId);
	                    imageData.setImage(uploadDirectory +"/"+ fileName);
	                    
	                    int imageResult = plannerService.saveReviewImage(imageData);
	                    
	                    if (imageResult >0) {
	                    	logger.info("review_ image : "+imageData);
	                    }
	                    else {
	                    	logger.info("리뷰 이미지 정보 저장에 실패했습니다.");
	                    }
	                }
	            }

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
	public String reviewDetail(@RequestParam("planner_id") int plannerId, HttpServletRequest request) {
	    try {
	        List<Planner_Review> review = plannerService.getReviewDetail(plannerId);
	        logger.info("request planner_id" + plannerId);
	        logger.info("review" + review);
	        // 리뷰 상세 정보를 모델에 담아서 전달
	        request.setAttribute("reviewList", review);

	        //return "review_detail";
	    } catch (Exception e) {
	        logger.error("리뷰 상세 정보 가져오기에서 오류가 발생했습니다: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return "review_detail";
	}



}