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

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class PlannerController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PlannerController.class);

	@Autowired
	private PlannerService plannerService;

	@RequestMapping(value = "/planner/login")
	public String loginGet(Model model) {
		return "login2";
	}

	@RequestMapping(value = "/planner/login", method = RequestMethod.POST)
	public String loginPost(Planner vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Planner returnVO = plannerService.loginUser(vo.getAccount_id(), vo.getPassword());

		if (returnVO != null) {
			/* session.setAttribute("member", returnVO.getMember_id()); */
			HttpSession session = request.getSession();
			session.setAttribute(PlannerSession.PLANNER_SESSION_KEY, String.valueOf(returnVO.getAccount_id()));
			session.setAttribute("p_isLogin", PlannerSession.isLoginUser(returnVO.getAccount_id(), session));
			return "redirect:/";

		}
		else {
			request.setAttribute("loginFailde", true);
			return "redirect:/planner/login";
		}

	}

	// 로그아웃
	@RequestMapping(value = "/planner/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (PlannerSession.PLANNER_SESSION_KEY != null)
			session.removeAttribute(PlannerSession.PLANNER_SESSION_KEY);
		session.invalidate();

		return "redirect:/planner/login";
	}

	@RequestMapping(value = "/planner/mypage", method = RequestMethod.GET)
	public String myPageGet(HttpServletRequest request) {
		if (!PlannerSession.hasLogined(request.getSession())) {
			return "login";
		}
		return "mypage";
	}

	@RequestMapping(value = "/planner/mypage/chat")
	public String myChatGet(HttpServletRequest request) throws Exception {
		String account_id = PlannerSession.getLoginUserId(request.getSession());
		Planner returnVo = plannerService.selectOne2(account_id);
		logger.info("현재유저 " + returnVo);
		request.setAttribute("LoginPlanner", returnVo);

		return "userChat";
	}

}
