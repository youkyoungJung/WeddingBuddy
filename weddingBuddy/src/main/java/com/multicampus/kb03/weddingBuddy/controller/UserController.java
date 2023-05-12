package com.multicampus.kb03.weddingBuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @RequestMapping(value="/login")
    public String loginGet(Model model) {     
        return "login";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginPost(Model model) {
    	
    	return "index";
    }
        
}
