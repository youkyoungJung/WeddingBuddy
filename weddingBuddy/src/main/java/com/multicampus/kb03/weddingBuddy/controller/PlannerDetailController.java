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
		
		// post로 선택한 날짜와 시간을 형식에 맞게 변환
		String reservation_date = date+" "+hour+":00";
        
		//현재 시간 기준으로 이후 시간만 예약시간으로 선택하도록 
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        
		if (reservation_date.compareTo(formattedDateTime) < 0) {
			model.addAttribute("reservation_message", "현재 이후 시간만 예약 가능합니다.");
			return "planner_detail";
		}

		// 해당 시간에 플래너 예약이 존재하는 경우
		if (chatReservationService.reservationExist(planner_id, reservation_date)) {
			model.addAttribute("reservation_message", "이미 예약된 시간입니다.");
			return "planner_detail";
		}
		User user = userService.selectOne(UserSession.getLoginUserId(session));
		
		int user_id = user.getUser_id();
		
		// 예약과 동시에 채팅을 생성한다.(채팅이 없다면)
		if (chatService.chatting_notExist(user_id, planner_id)) 
			chatService.insertNewChat(user_id, planner_id);
		int chatting_id = chatService.selectChattingId(user_id, planner_id);
		logger.info("chatid: "+chatting_id);
		logger.info("reserdate:"+reservation_date);
		
		
		chatReservationService.insertReservation(chatting_id, reservation_date);
		return "planner_reservation";
		
	}


}
