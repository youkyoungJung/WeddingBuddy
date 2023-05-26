package com.multicampus.kb03.weddingBuddy.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

public class PlannerSession implements Serializable {

	public static final String PLANNER_SESSION_KEY = "account_id";

    public static String getLoginUserId(HttpSession session) {
        String userId = (String)session.getAttribute(PLANNER_SESSION_KEY);
        return userId;
    }

    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) != null) {
            return true;
        }
        return false;
    }
    
	public static boolean isLoginUser(String account_id, HttpSession session) {
        String loginMember = getLoginUserId(session);
        if (loginMember == null || !loginMember.equals(account_id)) {
            return false;
        }
        return true;
        
	}

}
