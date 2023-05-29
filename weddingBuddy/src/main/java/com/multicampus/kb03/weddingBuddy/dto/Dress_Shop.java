package com.multicampus.kb03.weddingBuddy.dto;

public class Dress_Shop {
	private int dress_shop_id;
	private String name;
	private String address;
	private String phone;
	private int price_range;
	private int company_unique_id;
	public int getDress_shop_id() {
		return dress_shop_id;
	}
	public void setDress_shop_id(int dress_shop_id) {
		this.dress_shop_id = dress_shop_id;
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
	@Override
	public String toString() {
		return "Dress_Shop [dress_shop_id=" + dress_shop_id + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", price_range=" + price_range + ", company_unique_id=" + company_unique_id + "]";
	}
}
