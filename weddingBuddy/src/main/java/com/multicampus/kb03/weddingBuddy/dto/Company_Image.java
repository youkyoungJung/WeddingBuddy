package com.multicampus.kb03.weddingBuddy.dto;

public class Company_Image {
	int company_image_id;
	int company_unique_id;
	String image;
	
	public int getCompany_image_id() {
		return company_image_id;
	}
	public void setCompany_image_id(int company_image_id) {
		this.company_image_id = company_image_id;
	}
	public int getCompany_unique_id() {
		return company_unique_id;
	}
	public void setCompany_unique_id(int company_unique_id) {
		this.company_unique_id = company_unique_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Company_Image [company_image_id=" + company_image_id + ", company_unique_id=" + company_unique_id
				+ ", image=" + image + "]";
	}
	
}
