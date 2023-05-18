package com.multicampus.kb03.weddingBuddy.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;


@Controller
@RequestMapping("/review")
public class ReviewController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private PlannerService plannerService;
    
	@GetMapping
	public String ReviewGet(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception { 
//    	List<Planner> returnVo1 = plannerService.selectAll();
//    	logger.info("Planner selectAll " + returnVo1);
//    	request.setAttribute("plannerTop3", returnVo1);
        return "review";
    }
    
        
}
