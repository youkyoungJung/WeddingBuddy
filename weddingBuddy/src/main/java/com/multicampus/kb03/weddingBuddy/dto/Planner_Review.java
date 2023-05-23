package com.multicampus.kb03.weddingBuddy.dto;

public class Planner_Review {
	private int review_id;
	private String planner_id;
	private String user_id;
	private String reg_date;
	private String url;
	private String content;
	
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getPlanner_id() {
		return planner_id;
	}
	public void setPlanner_id(String planner_id) {
		this.planner_id = planner_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
				+ ", reg_date=" + reg_date + ", url=" + url + ", content=" + content + "]";
	}
	
	
}
