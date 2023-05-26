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
    public String main(@RequestParam("to_id") int to_id, @RequestParam("from_id") int from_id, Model model) throws Exception {
    	model.addAttribute("to_id", to_id);
    	model.addAttribute("from_id", from_id);
    	
    	return "start";
    }
        
}
