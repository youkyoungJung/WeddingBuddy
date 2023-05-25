package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Message;

public interface ChatDao {
	//ä�� 
		public List<Message> chatList(Message m)throws Exception;

		//�޽�����
		public List<Message> messagebox(int to_id)throws Exception;

		//�޽���������
		public void messagesend(Message m)throws Exception;

		public void insertNewChat(int user_id, int planner_id);

		public int selectChattingId(int user_id, int planner_id);
		
		
}
