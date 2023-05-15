package com.multicampus.kb03.weddingBuddy.controller;

import java.util.Arrays;
import java.util.List;

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

import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.UserService;


@Controller
@RequestMapping("/search/planner/detail")
public class PlannerDetailController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PlannerDetailController.class);

	@Autowired
	private UserService userService;
    
	@GetMapping
	public String searchPlannerDetailGet(Model model) {     
		
		 // 이미지 URL 리스트를 모델에 추가
        List<String> images = Arrays.asList(
            "/images/logo.jpg",
            "/images/logo.jpg",
            "/images/logo.jpg"
        );
        model.addAttribute("images", images);
       // return "index";
        
        
        return "planner_detail";
    }
    
        
}
