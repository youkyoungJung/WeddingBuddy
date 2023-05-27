package com.multicampus.kb03.weddingBuddy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
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

	    // 플래너 정보 조회
	    Planner planner = plannerService.selectOne(planner_id);
	    int agency_id = planner.getAgency_id();
	    Agency agency = agencyService.selectOne(agency_id);

	    session.setAttribute("agency", agency);
	    session.setAttribute("planner", planner);
	    logger.info("플래너 ID: " + planner_id);
	    
	    // 플래너에 대한 최신 3개 리뷰 조회
	    List<Planner_Review> top3Reviews = plannerService.getTop3ReviewsByPlannerId(planner_id);
	    model.addAttribute("top3Reviews", top3Reviews);
	    
	    // 리뷰 이미지 정보를 가져오기 위해 Review_Image 클래스 대신 Map<String, String> 형태로 변경합니다.
        List<Map<String, String>> reviewImagesList = new ArrayList<>();
	    
	    // 리뷰 작성자의 유저네임 가져오기
	    List<String> userNames = new ArrayList<>();
	    for (Planner_Review review : top3Reviews) {
	        String userName = plannerService.getUserAccountName(review.getUser_id());
	        userNames.add(userName);
	        
	        List<Review_Image> reviewImages = plannerService.getReviewImages(review.getReview_id());

            for (Review_Image reviewImage : reviewImages) {
                // 리뷰 이미지의 review_id와 image를 Map 형태로 변환하여 리스트에 추가합니다.
                Map<String, String> reviewImageMap = new HashMap<>();
                reviewImageMap.put("review_id", String.valueOf(reviewImage.getReview_id()));
                String imagePath = reviewImage.getImage();
                String trimmedImagePath = imagePath.substring(imagePath.indexOf("/static") + 7); // "/static" 이후의 부분만 가져옴
                reviewImageMap.put("image", trimmedImagePath);
                reviewImagesList.add(reviewImageMap);
                logger.info("reviewImageMap : "+ reviewImageMap);
            }
	        
	    }
	    model.addAttribute("userNames", userNames);
	    model.addAttribute("reviewImagesList", reviewImagesList);
	    
	    return "planner_detail";
	}

	
	
	@RequestMapping(value="/search/planner/detail", method=RequestMethod.POST)
	public String searchPlannerDetailPost(Model model, @RequestParam("planner_id") int planner_id, 
			@RequestParam("date") String date, @RequestParam("hour") String hour, 
			HttpSession session) throws Exception {
		String reservation_date = date+" "+hour+":00";
		logger.info(reservation_date);

		if (chatReservationService.reservationExist(planner_id, reservation_date)) {
			model.addAttribute("reservation_message", "이미 예약된 시간입니다.");
			return "planner_detail";
		}
		User user = userService.selectOne(UserSession.getLoginUserId(session));
		
		int user_id = user.getUser_id();
		
		// 예약과 동시에 채팅을 생성한다.
		chatService.insertNewChat(user_id, planner_id);
		int chatting_id = chatService.selectChattingId(user_id, planner_id);
		logger.info("chatid: "+chatting_id);
		logger.info("reserdate:"+reservation_date);
		chatReservationService.insertReservation(chatting_id, reservation_date);
		
		
		return "planner_reservation";
		
	}
	
	

}
