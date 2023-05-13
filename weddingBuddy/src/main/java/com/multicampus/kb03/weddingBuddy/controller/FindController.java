package com.multicampus.kb03.weddingBuddy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.UserService;


@Controller
public class FindController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FindController.class);

	@Autowired
	private UserService userService;
    
    @RequestMapping(value="/search/planner")
    public String findPlannerGet(Model model) {     
        return "planner_search";
    }
    
        
}
