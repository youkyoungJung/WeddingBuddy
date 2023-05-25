package com.multicampus.kb03.weddingBuddy.dto;

public class ChattingDto {
	private int user_id;
	private int planner_id;
	private int chatting_id;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPlanner_id() {
		return planner_id;
	}
	public void setPlanner_id(int planner_id) {
		this.planner_id = planner_id;
	}
	public int getChatting_id() {
		return chatting_id;
	}
	public void setChatting_id(int chatting_id) {
		this.chatting_id = chatting_id;
	}
	@Override
	public String toString() {
		return "ChattingDto [user_id=" + user_id + ", planner_id=" + planner_id + ", chatting_id=" + chatting_id + "]";
	}
}
