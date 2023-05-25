package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.kb03.weddingBuddy.controller.MessageController;
import com.multicampus.kb03.weddingBuddy.dto.Message;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.repository.ChatDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.ChatMapper;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.PlannerMapper;

@Repository
class MyBatisChatDao implements ChatDao {

	@Autowired
	private ChatMapper chatMapper;
	
	@Override
	public List<Message> chatList(Message m) throws Exception {
		return chatMapper.chatList(m);
	}

	@Override
	public List<Message> messagebox(int to_id) throws Exception {
		List<Message> messagebox = chatMapper.messagebox(to_id);
		
		System.out.println("�� ũ��� " + messagebox.size());
		if (messagebox.size() == 0) {
			
		}
		for(int i = 0; i < messagebox.size(); i++) {
			Message x = messagebox.get(i); // 
			
			for(int j = 0; j < messagebox.size(); j++) {
				Message y = messagebox.get(j);
				
				if(x.getTo_id() ==y.getFrom_id() && x.getFrom_id() == y.getTo_id()) {

					if(x.getMessage_id() < y.getMessage_id()) {
						messagebox.remove(x);
						i--;
						break;
					}else {
						messagebox.remove(y);
						j--;
					}				
				}
			
			}				
		}
		return messagebox;
	}

	@Override
	public void messagesend(Message m) throws Exception {
		chatMapper.messagesend(m);
	}

	@Override
	public void insertNewChat(int user_id, int planner_id) {
		chatMapper.insertNewChat(user_id, planner_id);
	}

	@Override
	public int selectChattingId(int user_id, int planner_id) {
		return chatMapper.selectChattingId(user_id, planner_id);
	}

}
