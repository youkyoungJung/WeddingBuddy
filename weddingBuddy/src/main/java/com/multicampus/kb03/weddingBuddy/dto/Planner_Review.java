package com.multicampus.kb03.weddingBuddy.dto;

import java.util.List;

public class Planner_Review {
	private int review_id;
	private int planner_id;
	private int user_id;
	private String reg_date;
	private String content;
	
	public int getPlanner_id() {
		return planner_id;
	}
	public void setPlanner_id(int planner_id) {
		this.planner_id = planner_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Planner_Review [review_id=" + review_id + ", planner_id=" + planner_id + ", user_id=" + user_id
				+ ", reg_date=" + reg_date + ", content=" + content + "]";
	}

	
	
}
