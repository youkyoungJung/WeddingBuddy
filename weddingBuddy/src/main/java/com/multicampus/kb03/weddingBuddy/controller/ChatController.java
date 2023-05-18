package com.multicampus.kb03.weddingBuddy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.ChatService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/userChat")
    public String getChatList(HttpServletRequest request, Model model) {
        try {
            String accountId = UserSession.getLoginUserId(request.getSession());
            User user = userService.selectOne(accountId);
            
            List<Planner> planners = userService.chattingWithSomeone(user.getUser_id());
            
            model.addAttribute("LoginUser", user);
            model.addAttribute("chatPlanner", planners);
            
            return "userChat";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
