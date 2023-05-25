package com.multicampus.kb03.weddingBuddy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LikedPlannerController {

    private List<Integer> likedPlannerIds = new ArrayList<>();

    @RequestMapping(value = "/likedPlanners", method = RequestMethod.GET)
    public String likedPlanners(Model model) {
        model.addAttribute("likedPlannerIds", likedPlannerIds);
        return "likedPlanners";
    }

    @RequestMapping(value = "/addLikedPlanner", method = RequestMethod.POST)
    public ResponseEntity<String> addLikedPlanner(@RequestParam("plannerId") int plannerId) {
        likedPlannerIds.add(plannerId);
        return new ResponseEntity<>("Planner added to liked list", HttpStatus.OK);
    }
    
    @GetMapping("/like")
    public String like(Model model) {
    	model.addAttribute("likedPlannerIds", likedPlannerIds);
		return "like";
    	
    }
}

