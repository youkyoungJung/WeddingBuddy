package com.multicampus.kb03.weddingBuddy.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class UserController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PlannerService plannerService;

	@RequestMapping(value = "/login")
	public String loginGet(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(User vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

	
		User returnVO = userService.loginUser(vo.getAccount_id(), vo.getPassword());

		if (returnVO != null) {
			/* session.setAttribute("member", returnVO.getMember_id()); */
			HttpSession session = request.getSession();
			session.setAttribute(UserSession.MEMBER_SESSION_KEY, String.valueOf(returnVO.getAccount_id()));
			session.setAttribute("isLogin", UserSession.isLoginUser(returnVO.getAccount_id(), session));
			return "redirect:/";

		}
		else {
			request.setAttribute("loginFailde", true);
			return "redirect:/login";
		}

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (UserSession.MEMBER_SESSION_KEY != null)
			session.removeAttribute(UserSession.MEMBER_SESSION_KEY);
		session.invalidate();

		return "redirect:/login";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPageGet(HttpServletRequest request) {
//		if (!UserSession.hasLogined(request.getSession())) {
//			return "login";
//		}
//		if(!UserSession.hasLogined(request.getSession()) && PlannerSession.hasLogined(request.getSession())) { //유저세션이 없고, 플래너세션이 있으면 플래너 아이디 담음
//			String planner_account = PlannerSession.getLoginUserId(request.getSession());
//			request.setAttribute("planner_account", planner_account);
//			return "mypage";
//		}
//		//유저 세션을 담음
//		String user_account = UserSession.getLoginUserId(request.getSession());
//		request.setAttribute("user_account", user_account);
		return "mypage";
	}

	@RequestMapping(value = "/mypage/chat")
	public String myChatGet(HttpServletRequest request, HttpSession session) throws Exception {
		String account_id = UserSession.getLoginUserId(request.getSession());
		logger.info("/my/chat : user: " + account_id);
		User returnVo = userService.selectOne(account_id);
		Planner returnVo2 = plannerService.selectOne2(account_id);
		
		if(returnVo2 == null && returnVo != null) {
			logger.info("현재유저 " + returnVo);
			List<Planner> p_returnVo = userService.chattingWithSomeone(returnVo.getUser_id());
			request.setAttribute("chatPlanner", p_returnVo);
			request.setAttribute("LoginUser", returnVo);
			return "userChat";
		}
		else 
			
			if((returnVo2 != null && returnVo == null) ) {
			List<User> p_returnVo = plannerService.chattingWithSomeone(returnVo2.getPlanner_id());
			request.setAttribute("PlannerInfo", p_returnVo);
			request.setAttribute("ChatWithUser", returnVo2);
			logger.info("플래너현재유저 PlannerInfo: " + p_returnVo);
			logger.info("플래너랑 채팅하는 사람 ChatWithInfo: " + returnVo2);
			return "plannerChat";
		}
		return null;
	}

}
