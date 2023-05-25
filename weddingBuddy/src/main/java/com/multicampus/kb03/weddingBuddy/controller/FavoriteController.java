package com.multicampus.kb03.weddingBuddy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.PlannerMapper;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class FavoriteController {

    @Autowired
    private PlannerMapper plannerMapper;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value="/updateFavorite", method = RequestMethod.POST)
    public String favoriteStatus(@RequestParam("planner_id") int plannerId,
                                 @RequestParam("isFavorite") boolean isFavorite,
                                 Model model, HttpSession session) {
       
      
        String accountId = UserSession.getLoginUserId(session);
        int user_id = userService.selectUserIdByAccountId(accountId);
        System.out.println(" "+user_id);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", user_id);
        parameters.put("plannerId", plannerId);
        parameters.put("isFavorite", isFavorite);
        plannerMapper.insertPlannerLike(parameters);
        
        if(isFavorite) {
        	model.addAttribute("plannerId", plannerId);
        	model.addAttribute("isFavorite", isFavorite);
        }
      

        return "like";
    }

   
}
