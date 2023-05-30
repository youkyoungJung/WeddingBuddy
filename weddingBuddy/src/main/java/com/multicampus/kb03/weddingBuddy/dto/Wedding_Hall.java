package com.multicampus.kb03.weddingBuddy.dto;

public class Wedding_Hall {
	private int wedding_hall_id;
	private String name;
	private String address;
	private String phone;
	private int price_range;
	private int company_unique_id;
	
	@Override
	public String toString() {
		return "Wedding_Hall [wedding_hall_id=" + wedding_hall_id + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", price_range=" + price_range + ", company_unique_id=" + company_unique_id
				+ "]";
	}
	public int getWedding_hall_id() {
		return wedding_hall_id;
	}
	public void setWedding_hall_id(int wedding_hall_id) {
		this.wedding_hall_id = wedding_hall_id;
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
	public int getPrice_range() {
		return price_range;
	}
	public void setPrice_range(int price_range) {
		this.price_range = price_range;
	}
	public int getCompany_unique_id() {
		return company_unique_id;
	}
	public void setCompany_unique_id(int company_unique_id) {
		this.company_unique_id = company_unique_id;
	}
	
}
