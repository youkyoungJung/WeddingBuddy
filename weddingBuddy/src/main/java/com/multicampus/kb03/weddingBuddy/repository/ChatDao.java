package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Message;

public interface ChatDao {
	//채팅 
		public List<Message> chatList(Message m)throws Exception;

		//메시지함
		public List<Message> messagebox(int to_id)throws Exception;

		//메시지보내기
		public void messagesend(Message m)throws Exception;
}
