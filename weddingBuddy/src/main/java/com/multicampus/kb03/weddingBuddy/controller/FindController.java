package com.multicampus.kb03.weddingBuddy.controller;

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

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;


@Controller
@RequestMapping("/search/planner")
public class FindController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FindController.class);

	@Autowired
	private PlannerService plannerService;
    
	@GetMapping
	public String findPlannerGet(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception { 
    	List<Planner> returnVo1 = plannerService.selectAll();
    	logger.info("Planner selectAll " + returnVo1);
    	request.setAttribute("plannerTop3", returnVo1);
        return "planner_search";
    }
    
        
}
