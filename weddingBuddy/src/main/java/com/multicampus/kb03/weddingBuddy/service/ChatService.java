package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Message;

public interface ChatService {
	//ä��
	public List<Message> chatList(Message msg) throws Exception;

	//�޽�����
	public List<Message> messagebox(int to_id)throws Exception;

	//�޽���������
	public void messagesend(Message m)throws Exception;
	
}
