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
		User returnVO = userService.loginUser(vo.getAccount_id(), vo.getPassword());

		logger.info("리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) " + returnVO);

		if (returnVO != null) {
			// 세션값생성
			// �꽭�뀡媛믪깮�꽦
			/* session.setAttribute("member", returnVO.getMember_id()); */
			HttpSession session = request.getSession();
			session.setAttribute(UserSession.MEMBER_SESSION_KEY, String.valueOf(returnVO.getAccount_id()));
			session.setAttribute("isLogin", UserSession.isLoginUser(returnVO.getAccount_id(), session));
			return "redirect:/";

		} else {
			// �빐�떦 �젙蹂� �뾾�뒗 寃쎌슦 : => login�럹�씠吏�濡� �씠�룞
			request.setAttribute("loginFailde", true);
			return "redirect:/login";
		}

	}

	// 濡쒓렇�븘�썐
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		// �꽭�뀡�뿉 ���옣�맂 �궗�슜�옄 �씠�씠�뵒瑜� �궘�젣�븯怨� �꽭�뀡�쓣 臾댄슚�솕 �븿
		HttpSession session = request.getSession();
		session.removeAttribute(UserSession.MEMBER_SESSION_KEY);
		session.invalidate();
		logger.info("濡쒓렇�씤 �꽭�뀡 �걡�쓬");

		return "redirect:/login";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPageGet(HttpServletRequest request) {
		//濡쒓렇�씤 �뿬遺� �솗�씤
		if(!UserSession.hasLogined(request.getSession())) {
			return "login";
		}
		return "mypage";
	}

	@RequestMapping(value = "/mypage/chat")
	public String myChatGet(HttpServletRequest request) throws Exception {
		String account_id = UserSession.getLoginUserId(request.getSession());
		User returnVo = userService.selectOne(account_id);
		logger.info("현재유저 " + returnVo);
		
		List<Planner> p_returnVo = userService.chattingWithSomeone(returnVo.getUser_id());
		request.setAttribute("chatPlanner", p_returnVo);
		logger.info("현재유저 " + p_returnVo);
		request.setAttribute("LoginUser", returnVo);
//		
		return "userChat";
		//return "chat";
	}

}
