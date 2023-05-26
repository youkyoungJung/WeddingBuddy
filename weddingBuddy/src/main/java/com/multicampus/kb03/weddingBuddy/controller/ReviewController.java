package com.multicampus.kb03.weddingBuddy.controller;



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

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;


@Controller
@RequestMapping("/review")
public class ReviewController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReviewController.class);
    
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
    
        
}
