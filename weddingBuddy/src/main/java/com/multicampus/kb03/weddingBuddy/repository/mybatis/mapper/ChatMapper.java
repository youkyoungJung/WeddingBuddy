package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.multicampus.kb03.weddingBuddy.dto.ChattingDto;

@Mapper
public interface ChatMapper {

	public int select(ChattingDto chat);

}
