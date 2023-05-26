package com.multicampus.kb03.weddingBuddy.dto;

public class Planner {
	
	private int planner_id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private int agency_id;
	private String intro;
	private String region;
	private String account_id;
	
	public int getPlanner_id() {
		return planner_id;
	}
	public void setPlanner_id(int planner_id) {
		this.planner_id = planner_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		return "Planner [planner_id=" + planner_id + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", agency_id=" + agency_id + ", intro=" + intro + ", region=" + region
				+ ", account_id=" + account_id + "]";
	}
	
}
