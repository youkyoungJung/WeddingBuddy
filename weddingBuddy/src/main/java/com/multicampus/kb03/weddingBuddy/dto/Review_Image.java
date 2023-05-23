package com.multicampus.kb03.weddingBuddy.dto;

public class Review_Image {
	private int review_image_no;
	private int review_no;
	private String image_url;
	
	public int getReview_image_no() {
		return review_image_no;
	}
	public void setReview_image_no(int review_image_no) {
		this.review_image_no = review_image_no;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	@Override
	public String toString() {
		return "Review_Image [review_image_no=" + review_image_no + ", review_no=" + review_no + ", image_url="
				+ image_url + "]";
	}
	
	
	
}
