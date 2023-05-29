package com.multicampus.kb03.weddingBuddy.dto;

public class PlannerSearch {
	private int agency_id;
	private String name;
	private String address;
	private String phone;
	private String agency_name;
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
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
	
	@Override
	public String toString() {
		return "PlannerSearch [agency_id=" + agency_id + ", name=" + name + ", address=" + address + ", phone=" + phone
				 + " agency_name=" +agency_name;
	}
	
	
	
}
