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
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class UserController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public String loginGet(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(User vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// User returnVo = null;
		logger.info("로그인처리 페이지 진입 loginPOST");
		logger.info("vo 넘어오는가" + vo);
		User returnVO = userService.loginUser(vo.getAccount_id(), vo.getPassword());

		logger.info("리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) " + returnVO);

		if (returnVO != null) {
			// 세션값생성
			/* session.setAttribute("member", returnVO.getMember_id()); */
			HttpSession session = request.getSession();
			session.setAttribute(UserSession.MEMBER_SESSION_KEY, String.valueOf(returnVO.getAccount_id()));
			session.setAttribute("isLogin", UserSession.isLoginUser(returnVO.getAccount_id(), session));
			return "redirect:/";

		} else {
			// 해당 정보 없는 경우 : => login페이지로 이동
			request.setAttribute("loginFailde", true);
			return "redirect:/login";
		}

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		// 세션에 저장된 사용자 이이디를 삭제하고 세션을 무효화 함
		HttpSession session = request.getSession();
		session.removeAttribute(UserSession.MEMBER_SESSION_KEY);
		session.invalidate();
		logger.info("로그인 세션 끊음");

		return "redirect:/login";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPageGet(HttpServletRequest request) {
		//로그인 여부 확인
		if(!UserSession.hasLogined(request.getSession())) {
			return "login";
		}
		return "mypage";
	}

	@RequestMapping(value = "mypage/userChat")
	public String myChatGet(HttpServletRequest request) throws Exception {
		String account_id = UserSession.getLoginUserId(request.getSession());
		User returnVo = userService.selectOne(account_id);
		logger.info("마이페이지 사용자 " + returnVo);
		
		List<Planner> p_returnVo = userService.chattingWithSomeone(returnVo.getUser_id());
		request.setAttribute("chatPlanner", p_returnVo);
		//사용자 정보 담음
		request.setAttribute("LoginUser", returnVo);
		
		
		return "userChat";
	}
	
	
	
	/*
	 * @RequestMapping(value = "mypage/like") public String
	 * myLikeGet(HttpServletRequest request) throws Exception{ String account_id =
	 * UserSession.getLoginUserId(request.getSession());
	 * 
	 * return "like"; }
	 */
	 

}
