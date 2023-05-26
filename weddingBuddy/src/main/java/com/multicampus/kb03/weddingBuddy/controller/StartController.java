package com.multicampus.kb03.weddingBuddy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;

@Controller
public class StartController {
    
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StartController.class);
	
    @RequestMapping(value="/start", method=RequestMethod.GET)
    public String main(@RequestParam("user_id") String user_id, @RequestParam("planner_id") String planner_id, Model model) throws Exception {
    	logger.info("planner_id"+planner_id);
    	model.addAttribute("to_id", user_id);
    	model.addAttribute("from_id", planner_id);
    	
    	return "start";
    }
        
}
