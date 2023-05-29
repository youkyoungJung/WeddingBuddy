package com.multicampus.kb03.weddingBuddy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multicampus.kb03.weddingBuddy.dto.Message;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.ChatService;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class MessageController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private ChatService service;
	
	@Autowired
	private UserService userService;

	@Autowired
	private PlannerService plannerService;
	
	/*
	 * //메세지함
	 * 
	 * @RequestMapping("/chat/{to_id}") public ModelAndView messageBox(@PathVariable
	 * String to_id) throws Exception {
	 * 
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * List<Message> messagebox = service.messagebox(to_id);
	 * 
	 * mav.addObject("box", messagebox); mav.setViewName("talker_list");
	 * 
	 * System.out.println("controller"); return mav; }
	 */

	// 개인당 메시지 주고받음
	@RequestMapping("/chat/{to_id}/{from_id}")
	public ModelAndView messageList(@PathVariable int to_id, @PathVariable int from_id, Message msg, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();
		logger.info("msg담긴것: " + msg);

		logger.info("to_id: " + to_id + "from_id: "+from_id);
		List<Message> chatlist = service.chatList(msg);

		logger.info("chatlist 크기 " + chatlist.size());
		logger.info("chatting " + chatlist);
		

		// 채팅 _id 가져오기(user일 경우만됨)
		int chatting_id = service.selectChattingId(to_id, from_id);
		
		HttpSession session = request.getSession();
		session.setAttribute("to_id", to_id);
		session.setAttribute("from_id", from_id);
		session.setAttribute("chatting_id", chatting_id);

		
		mav.setViewName("chat");
		mav.addObject("list", chatlist);
		mav.addObject("to_id", to_id);
		mav.addObject("from_id", from_id);

		return mav;
	}

	// 메시지 보내기
	@RequestMapping(value = "/chat/send", method = RequestMethod.POST)
	public ModelAndView messagesend(@ModelAttribute Message m, HttpServletRequest request,  HttpSession session) throws Exception {


		int to_id = (int) session.getAttribute("to_id");
		int from_id = (int) session.getAttribute("from_id");
		int chatting_id = (int) session.getAttribute("chatting_id");

		m.setTo_id(to_id);
		m.setChatting_id(chatting_id);

		service.messagesend(m);


		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/chat/" + to_id + "/" + from_id);

		return mav;
	}

	// rest 이용하여 메세지 받기
	@ResponseBody
	@GetMapping(value = "/chat/{to_id}/{from_id}/list.json", produces = "application/json")
	public List<Message> getMessage(@PathVariable int to_id, @PathVariable int from_id, Message m)
			throws Exception {

		//logger.info("요기까진 왔니");
		m.setTo_id(to_id);
		m.setFrom_id(from_id);

		List<Message> messagelist = service.chatList(m);

		return messagelist;
	}

}
