package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Message;
import com.multicampus.kb03.weddingBuddy.repository.ChatDao;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	ChatDao dao;
	
	@Override
	public List<Message> chatList(Message msg) throws Exception {
		return dao.chatList(msg);
	}

	//�޼�����
	@Override
	public List<Message> messagebox(int to_id) throws Exception {
		return dao.messagebox(to_id);
	}

	@Override
	public void messagesend(Message m) throws Exception {
		dao.messagesend(m);
	}

	@Override
	public void insertNewChat(int user_id, int planner_id) {
		dao.insertNewChat(user_id, planner_id);
	}

	@Override
	public int selectChattingId(int user_id, int planner_id) {
		return dao.selectChattingId(user_id, planner_id);
	}

	@Override
	public boolean chatting_notExist(int user_id, int planner_id) {
		if (dao.chattingCountBetweenUserAndPlanner(user_id, planner_id) == 0)
			return true;
		return false;
	}

}
