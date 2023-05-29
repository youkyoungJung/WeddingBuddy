package com.multicampus.kb03.weddingBuddy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.multicampus.kb03.weddingBuddy.service.ChatReservationService;
import com.multicampus.kb03.weddingBuddy.service.ChatService;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class UserController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private ChatReservationService chatReservationService;
	
	@RequestMapping(value = "/login")
	public String loginGet(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(User vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// User returnVo = null;
		logger.info("濡쒓렇�씤泥섎━ �럹�씠吏� 吏꾩엯 loginPOST");
		logger.info("vo �꽆�뼱�삤�뒗媛�" + vo);
		User returnVO = userService.loginUser(vo.getAccount_id(), vo.getPassword());

		logger.info("由ы꽩VO寃곌낵(�꽌鍮꾩뒪�뿉�꽌 �삁�쇅泥섎━瑜� 吏꾪뻾�뻽�쑝誘�濡� null�씠 異쒕젰�릺硫� 肄붾뱶�뿉 臾몄젣�엳�떎�뒗 �쓽誘�) " + returnVO);

		if (returnVO != null) {
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
	public String myPageGet(HttpServletRequest request) throws Exception {
		if (!UserSession.hasLogined(request.getSession())) {
			  //현재 user_id 알수 있음

			return "login";
		}
		return "mypage";
	}

	@RequestMapping(value = "/mypage/chat")
	public String myChatGet(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		String account_id = UserSession.getLoginUserId(request.getSession());
		logger.info("/my/chat : user: " + account_id);
		User returnVo = userService.selectOne(account_id);
		Planner returnVo2 = plannerService.selectOne2(account_id);
		logger.info("user_account 조건문 들어가기 전: "+returnVo);
		logger.info("planner_account 조건문 들어가기 전: "+returnVo2);
		
		if(returnVo2 == null && returnVo != null) {
			logger.info("현재유저 " + returnVo);
			List<Planner> p_returnVo = userService.chattingWithSomeone(returnVo.getUser_id());
			request.setAttribute("chatPlanner", p_returnVo);
			request.setAttribute("LoginUser", returnVo);
			
			// ReviewController로 user_id 전달
		    int userId = returnVo.getUser_id(); // 사용자의 user_id 가져오기
		    System.out.println(userId);
		    model.addAttribute("user_id", userId); // user_id를 model에 추가
		    
		    Map<Integer, String> reservedDates = new HashMap<>();
		    
		    for (Planner planner : p_returnVo) {
		    	int planner_id = planner.getPlanner_id();
		    	
		    	int chatting_id = chatService.selectChattingId(userId, planner_id);
				String nextReservedDateTime = chatReservationService.selectNextReservedDatetime(chatting_id);
				// 사용자가 예약한 플래너 별 다음 예약 시간을 Map 에 저장.
				reservedDates.put(planner_id, nextReservedDateTime);
			}
			return "userChat";
		}
		else if((returnVo2 != null && returnVo == null) ) {
			List<User> p_returnVo = plannerService.chattingWithSomeone(returnVo2.getPlanner_id());
			request.setAttribute("PlannerInfo", p_returnVo);
			request.setAttribute("ChatWithUser", returnVo2);
			logger.info("플래너현재유저 PlannerInfo: " + p_returnVo);
			logger.info("플래너랑 채팅하는 사람 ChatWithInfo: " + returnVo2);
			return "plannerChat";
		}
		return null;
	}
//	@RequestMapping(value = "mypage/userChat")
//	public String myChatGet(HttpServletRequest request, Model model) throws Exception {
//
//		String account_id = UserSession.getLoginUserId(request.getSession());
//		User returnVo = userService.selectOne(account_id);
//		logger.info("현재유저 " + returnVo);
//		
//		List<Planner> p_returnVo = userService.chattingWithSomeone(returnVo.getUser_id());
//		request.setAttribute("chatPlanner", p_returnVo);
//		logger.info("현재유저 " + p_returnVo);
//		request.setAttribute("LoginUser", returnVo);
//
//
//		// ReviewController로 user_id 전달
//	    int userId = returnVo.getUser_id(); // 사용자의 user_id 가져오기
//	    System.out.println(userId);
//	    model.addAttribute("user_id", userId); // user_id를 model에 추가
//	    
//	    Map<Integer, String> reservedDates = new HashMap<>();
//	    
//	    for (Planner planner : p_returnVo) {
//	    	int planner_id = planner.getPlanner_id();
//	    	
//	    	int chatting_id = chatService.selectChattingId(userId, planner_id);
//			String nextReservedDateTime = chatReservationService.selectNextReservedDatetime(chatting_id);
//			// 사용자가 예약한 플래너 별 다음 예약 시간을 Map 에 저장.
//			reservedDates.put(planner_id, nextReservedDateTime);
//		}
//	    
//	    model.addAttribute("reservedDatesMap", reservedDates);
//		
//		return "userChat";
//
//	}

	
	  @RequestMapping(value = "mypage/like") 
	  public String myLikeGet(HttpServletRequest request) throws Exception{
		  String account_id = UserSession.getLoginUserId(request.getSession());
		  //현재 user_id 알수 있음
		  User returnVo = userService.selectOne(account_id);
		  //plannerService.deletePlannerLike(returnVo.getUser_id());
		  
		  List<Planner> returnPlanner = plannerService.selectPlannerLike(returnVo.getUser_id());
		  logger.info("returnPlanner: "+returnPlanner);
		  
		  //request에 List를 담아서 보냄
		  request.setAttribute("returnPlanner", returnPlanner);
		  
		  return "like"; 
	  }
	 

}
