package com.multicampus.kb03.weddingBuddy.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

public class UserSession implements Serializable {

	public static final String MEMBER_SESSION_KEY = "account_id";

	 /* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginUserId(HttpSession session) {
        String userId = (String)session.getAttribute(MEMBER_SESSION_KEY);
        return userId;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) != null) {
            return true;
        }
        return false;
    }
    
    /* 현재 로그인한 사용자의 ID가 accountId인지 검사 */
	public static boolean isLoginUser(String account_id, HttpSession session) {
        String loginMember = getLoginUserId(session);
        if (loginMember == null || !loginMember.equals(account_id)) {
            return false;
        }
        return true;
        
	}

}
