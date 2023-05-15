package com.multicampus.kb03.weddingBuddy.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;

@Controller
public class MainController {
    
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PlannerService plannerService;
	
    @RequestMapping(value="/")
    public String main(Model model) throws Exception {
    	List<Planner> returnVo = plannerService.selectAll();
    	logger.info("List 넘어오는가" + returnVo);
    	return "index";
    }
        
}
