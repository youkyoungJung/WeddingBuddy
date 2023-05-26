package com.multicampus.kb03.weddingBuddy.dto;

public class Agency {
	private int agency_id;
	private String name;
	private String address;
	private String phone;
	private int associate_id;
	public int getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAssociate_id() {
		return associate_id;
	}
	public void setAssociate_id(int associate_id) {
		this.associate_id = associate_id;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
