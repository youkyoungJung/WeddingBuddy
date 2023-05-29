package com.multicampus.kb03.weddingBuddy.dto;

public class ChatReservation {
	int	chat_reservation_id;
	String reservation_date;
	int chatting_id;
	int user_id;
	int planner_id;
	
	public ChatReservation() {
	}
	
	public int getChat_reservation_id() {
		return chat_reservation_id;
	}
	public void setChat_reservation_id(int chat_Reservation_id) {
		this.chat_reservation_id = chat_Reservation_id;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public int getChatting_id() {
		return chatting_id;
	}
	public void setChatting_id(int chatting_id) {
		this.chatting_id = chatting_id;
	}
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
	@Override
	public String toString() {
		return "ChatReservation [chat_Reservation_id=" + chat_reservation_id + ", reservation_date=" + reservation_date
				+ ", chatting_id=" + chatting_id + ", user_id=" + user_id + ", planner_id=" + planner_id + "]";
	}
	
	

}
