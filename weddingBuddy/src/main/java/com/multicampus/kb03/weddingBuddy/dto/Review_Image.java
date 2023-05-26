package com.multicampus.kb03.weddingBuddy.dto;

public class Review_Image {
	private int review_image_id;
	private int review_id;
	private String image;
	
	public int getReview_image_id() {
		return review_image_id;
	}
	public void setReview_image_id(int review_image_id) {
		this.review_image_id = review_image_id;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Review_Image [review_image_id=" + review_image_id + ", review_id=" + review_id + ", image=" + image
				+ "]";
	}
	
	
	
	
}
