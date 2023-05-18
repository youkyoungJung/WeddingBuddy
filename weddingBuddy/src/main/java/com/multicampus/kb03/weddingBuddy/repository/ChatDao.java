package com.multicampus.kb03.weddingBuddy.repository;

import com.multicampus.kb03.weddingBuddy.dto.ChattingDto;

public interface ChatDao {
	
	public int select(ChattingDto chat) throws Exception;

}