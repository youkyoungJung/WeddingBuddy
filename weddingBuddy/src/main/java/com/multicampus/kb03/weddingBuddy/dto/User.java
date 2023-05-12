package com.multicampus.kb03.weddingBuddy.dto;

public class User {
	private int user_id;
	private String account_id;
	private String name;
	private String password;
	private String phone;
	private String email;
	
	
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", account_id=" + account_id + ", name=" + name + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
}
