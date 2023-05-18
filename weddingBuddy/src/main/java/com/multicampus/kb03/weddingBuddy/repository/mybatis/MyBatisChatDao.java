package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.ChattingDto;
import com.multicampus.kb03.weddingBuddy.repository.ChatDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.ChatMapper;

@Repository
public class MyBatisChatDao implements ChatDao {

	@Autowired
	private ChatMapper mapper;

	@Override
	public int select(ChattingDto chat) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(chat);
	}



}
