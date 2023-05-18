package com.multicampus.kb03.weddingBuddy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.ChattingDto;
import com.multicampus.kb03.weddingBuddy.repository.ChatDao;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDao dao;
	
	@Override
	public int select(ChattingDto chat) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(chat);
	}



}
