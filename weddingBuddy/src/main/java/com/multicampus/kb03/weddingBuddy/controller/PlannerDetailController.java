package com.multicampus.kb03.weddingBuddy.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.kb03.weddingBuddy.dto.Agency;
import com.multicampus.kb03.weddingBuddy.dto.ChatReservation;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.AgencyService;
import com.multicampus.kb03.weddingBuddy.service.ChatReservationService;
import com.multicampus.kb03.weddingBuddy.service.ChatService;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller

public class PlannerDetailController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PlannerDetailController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatReservationService chatReservationService;


	@RequestMapping(value="/search/planner/detail", method = RequestMethod.GET)
	public String searchPlannerDetailGet(Model model, @RequestParam("planner_id") int planner_id, HttpSession session) throws Exception {

		Planner returnVo = plannerService.selectOne(planner_id);
		int agency_id = returnVo.getAgency_id();
		Agency agency = agencyService.selectOne(agency_id);

		session.setAttribute("agency", agency);
		session.setAttribute("planner", returnVo);
		return "planner_detail";
	}
	
	@RequestMapping(value="/search/planner/detail", method=RequestMethod.POST)
	public String searchPlannerDetailPost(Model model, @RequestParam("planner_id") int planner_id, 
			@RequestParam("date") String date, @RequestParam("hour") String hour, 
			HttpSession session) throws Exception {
		
		// post濡� �꽑�깮�븳 �궇吏쒖� �떆媛꾩쓣 �삎�떇�뿉 留욊쾶 蹂��솚
		String reservation_date = date+" "+hour+":00";
        
		//�쁽�옱 �떆媛� 湲곗��쑝濡� �씠�썑 �떆媛꾨쭔 �삁�빟�떆媛꾩쑝濡� �꽑�깮�븯�룄濡� 
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        
		if (reservation_date.compareTo(formattedDateTime) < 0) {
			model.addAttribute("reservation_message", "�쁽�옱 �씠�썑 �떆媛꾨쭔 �삁�빟 媛��뒫�빀�땲�떎.");
			return "planner_detail";
		}

		// �빐�떦 �떆媛꾩뿉 �뵆�옒�꼫 �삁�빟�씠 議댁옱�븯�뒗 寃쎌슦
		if (chatReservationService.reservationExist(planner_id, reservation_date)) {
			model.addAttribute("reservation_message", "�씠誘� �삁�빟�맂 �떆媛꾩엯�땲�떎.");
			return "planner_detail";
		}
		User user = userService.selectOne(UserSession.getLoginUserId(session));
		
		int user_id = user.getUser_id();
		
		// �삁�빟怨� �룞�떆�뿉 梨꾪똿�쓣 �깮�꽦�븳�떎.(梨꾪똿�씠 �뾾�떎硫�)
		if (chatService.chatting_notExist(user_id, planner_id)) 
			chatService.insertNewChat(user_id, planner_id);
		int chatting_id = chatService.selectChattingId(user_id, planner_id);
		logger.info("chatid: "+chatting_id);
		logger.info("reserdate:"+reservation_date);
		
		
		chatReservationService.insertReservation(chatting_id, reservation_date);
		return "planner_reservation";
		
	}


}
