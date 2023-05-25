package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multicampus.kb03.weddingBuddy.dto.Message;

@Mapper
public interface ChatMapper {

	public List<Message> chatList(Message m)throws Exception;

	// �޽�����
	public List<Message> messagebox(int to_id) throws Exception;

	// �޽���������
	public void messagesend(Message m) throws Exception;

}
