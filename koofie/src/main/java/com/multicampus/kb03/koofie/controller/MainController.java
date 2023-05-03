package com.multicampus.kb03.koofie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
    @RequestMapping(value="/")
    public String main(Model model) {
        //깃테스트해봅시다!!!
        return "index";
    }
        
}
