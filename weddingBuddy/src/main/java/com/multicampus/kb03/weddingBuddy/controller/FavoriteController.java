package com.multicampus.kb03.weddingBuddy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.multicampus.kb03.weddingBuddy.dto.Planner_Like;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.PlannerMapper;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;
import com.sun.org.slf4j.internal.Logger;

@Controller
public class FavoriteController {

    @Autowired
    private PlannerService plannerService;
    
    @Autowired
    private UserService userService;

    //ajax 작동 post
    @RequestMapping(value="/updateFavorite", method = RequestMethod.POST)
    public String favoriteStatus(@RequestParam("planner_id") int planner_id,
                                 @RequestParam("isFavorite") boolean isFavorite,
                                 Model model, HttpSession session) throws Exception {
       
      
        String accountId = UserSession.getLoginUserId(session);
        int user_id = userService.selectUserIdByAccountId(accountId);
        System.out.println("user_id: "+user_id + " isFavorite: "+isFavorite);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", user_id);
        parameters.put("plannerId", planner_id);
        parameters.put("isFavorite", isFavorite);
        
        model.addAttribute("planner_id",planner_id);
        
        
        System.out.println("parameters: " + parameters.toString());
        //plannerService 에서 기존 planner_like 가 있는지 확인
        Planner_Like planner_like = plannerService.getPlannerLike(user_id, planner_id);
        
        //없으면 insert, 있으면 delete
        if(planner_like != null) {
        	int planner_like_id = planner_like.getPlanner_like_id();
        	System.out.println("planner_like_id를 찾는가? : "+planner_like_id);
        	plannerService.deletePlannerLike(user_id, planner_like_id);
        	System.out.println("delete 수행하나?");
        	Planner_Like planner_like_2 = plannerService.getPlannerLike(user_id, planner_id);
            System.out.println("정보전달: "+ planner_like_2);
        } 
        else {
        	System.out.println("정보전달: "+ planner_like);
        	plannerService.insertPlannerLike(parameters);
        }	
        return "like";
    }
    

    
   
}
