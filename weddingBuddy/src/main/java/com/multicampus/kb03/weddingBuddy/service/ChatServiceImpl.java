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

	//메세지함
	@Override
	public List<Message> messagebox(int to_id) throws Exception {
		return dao.messagebox(to_id);
	}

	@Override
	public void messagesend(Message m) throws Exception {
		dao.messagesend(m);
	}

}
