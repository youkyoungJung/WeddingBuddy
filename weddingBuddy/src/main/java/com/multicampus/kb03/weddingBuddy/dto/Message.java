package com.multicampus.kb03.weddingBuddy.dto;

import java.io.Serializable;

public class Message implements Serializable{
	int message_id;
	int chatting_id;
	int from_id;
	int to_id;
	String chat_content;
	String timestamp;
	boolean chat_read_check;
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getChatting_id() {
		return chatting_id;
	}
	public void setChatting_id(int chatting_id) {
		this.chatting_id = chatting_id;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	public String getChat_content() {
		return chat_content;
	}
	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isChat_read_check() {
		return chat_read_check;
	}
	public void setChat_read_check(boolean chat_read_check) {
		this.chat_read_check = chat_read_check;
	}
	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", chatting_id=" + chatting_id + ", from_id=" + from_id
				+ ", to_id=" + to_id + ", chat_content=" + chat_content + ", timestamp=" + timestamp
				+ ", chat_read_check=" + chat_read_check + "]";
	}
	
	
}
