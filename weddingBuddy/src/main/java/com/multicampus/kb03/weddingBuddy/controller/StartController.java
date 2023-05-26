package com.multicampus.kb03.weddingBuddy.controller;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
