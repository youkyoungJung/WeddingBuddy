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
		logger.info("parameter�뿉 �엳�뒗 user_id: " + user_id);
		logger.info("parameter�뿉 �엳�뒗 planner_id: " + planner_id);
		model.addAttribute("user_id", user_id);
		model.addAttribute("planner_id", planner_id);

	@GetMapping
	public String ReviewGet(
			HttpServletRequest request, 
			HttpServletResponse response, @RequestParam("planner_id") String planner_id) throws Exception { 
		request.setAttribute("planner_id",planner_id);
        return "review";
    }
	@PostMapping
	public String ReviewPost(Planner_Review review, Review_Image image) {

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
	            logger.info("由щ럭 �젙蹂닿� �꽦怨듭쟻�쑝濡� ���옣�릺�뿀�뒿�땲�떎.");
	            int reviewId = reviewData.getReview_id();
	            logger.info("review_id: " + reviewId);

	            List<String> imageNames = new ArrayList<>();
	            for (MultipartFile imageFile : imageFiles) {
	                if (!imageFile.isEmpty()) {
	                    String fileName = generateUniqueFileName(imageFile.getOriginalFilename());
	                    String uploadDirectory = "/Users/jeongeunlee/git/WeddingBuddy/weddingBuddy/src/main/resources/static/review_images";
	                    File destFile = new File(uploadDirectory + "/" + fileName);

	                    destFile.createNewFile();
	                    System.out.println("�뙆�씪 �뾽濡쒕뱶 �꽦怨�");

	                    imageFile.transferTo(destFile);

	                    Review_Image imageData = new Review_Image();
	                    imageData.setReview_id(reviewId);
	                    imageData.setImage(uploadDirectory + "/" + fileName);

	                    int imageResult = plannerService.saveReviewImage(imageData);

	                    if (imageResult > 0) {
	                        logger.info("由щ럭 �씠誘몄� �젙蹂닿� �꽦怨듭쟻�쑝濡� ���옣�릺�뿀�뒿�땲�떎.");
	                        // �씠誘몄� �뙆�씪 �씠由� 異붽�
	                        imageNames.add(fileName);
	                    } else {
	                        logger.info("由щ럭 �씠誘몄� �젙蹂� ���옣�뿉 �떎�뙣�뻽�뒿�땲�떎.");
	                    }
	                }
	            }

	            // �씠誘몄� �뙆�씪 �씠由꾨뱾�쓣 Model 媛앹껜�뿉 異붽�
	            model.addAttribute("imageNames", imageNames);

	            return "redirect:/review/detail?planner_id=" + plannerId;
	        } else {
	            logger.info("由щ럭 �젙蹂� ���옣�뿉 �떎�뙣�뻽�뒿�땲�떎.");
	        }
	    } catch (Exception e) {
	        logger.error("由щ럭 ���옣 怨쇱젙�뿉�꽌 �삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return "review";
	}


	private String generateUniqueFileName(String originalFileName) {
		// 怨좎쑀�븳 �뙆�씪 �씠由� �깮�꽦 濡쒖쭅 援ы쁽
		// �삁�떆: ���엫�뒪�꺃�봽 + �썝蹂� �뙆�씪 �씠由�
		String timestamp = String.valueOf(System.currentTimeMillis());
		return timestamp + "_" + originalFileName;
	}

	@GetMapping("/review/detail")
	public String reviewDetail(@RequestParam("planner_id") int plannerId, Model model) {
	    try {
	        List<Planner_Review> reviewList = plannerService.getReviewDetail(plannerId);

	        // 由щ럭 �씠誘몄� �젙蹂대�� 媛��졇�삤湲� �쐞�빐 Review_Image �겢�옒�뒪 ���떊 Map<String, String> �삎�깭濡� 蹂�寃쏀빀�땲�떎.
	        List<Map<String, String>> reviewImagesList = new ArrayList<>();

	        // user_id�� name�쓽 留ㅽ븨 �젙蹂대�� 媛�吏� Map�쓣 �깮�꽦�빀�땲�떎.
	        Map<Integer, String> userAccountMap = new HashMap<>();

	        for (Planner_Review review : reviewList) {
	            // user_id瑜� �궎濡쒗븯�뿬 user_account�뿉�꽌 name 媛믪쓣 媛��졇�샃�땲�떎.
	            String name = plannerService.getUserAccountName(review.getUser_id());
	            userAccountMap.put(review.getUser_id(), name);

	            List<Review_Image> reviewImages = plannerService.getReviewImages(review.getReview_id());

	            for (Review_Image reviewImage : reviewImages) {
	                // 由щ럭 �씠誘몄��쓽 review_id�� image瑜� Map �삎�깭濡� 蹂��솚�븯�뿬 由ъ뒪�듃�뿉 異붽��빀�땲�떎.
	                Map<String, String> reviewImageMap = new HashMap<>();
	                reviewImageMap.put("review_id", String.valueOf(reviewImage.getReview_id()));
	                String imagePath = reviewImage.getImage();
	                String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7); // "/static" �씠�썑�쓽 遺�遺꾨쭔 媛��졇�샂
	                reviewImageMap.put("image", trimmedImagePath);
	                reviewImagesList.add(reviewImageMap);
	                logger.info("reviewImageMap : "+ reviewImageMap);
	            }
	        }

	        model.addAttribute("reviewList", reviewList);
	        model.addAttribute("reviewImagesList", reviewImagesList);
	        model.addAttribute("userAccountMap", userAccountMap); // user_id�� name�쓽 留ㅽ븨 �젙蹂대�� 紐⑤뜽�뿉 異붽��빀�땲�떎.

	        return "review_detail";
	    } catch (Exception e) {
	        logger.error("由щ럭 �긽�꽭 �젙蹂� 媛��졇�삤湲곗뿉�꽌 �삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return "error"; // �삤瑜� 諛쒖깮 �떆 error �럹�씠吏�濡� �씠�룞�븯�룄濡� �닔�젙�빐�빞 �븿
	}


}