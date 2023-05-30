package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Like;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

public interface PlannerService {
	// insert �쉶�썝媛��엯(異붽�/�궫�엯)
	public int insert(Planner planner) throws Exception;

	//update �닔�젙 
	public int update(Planner planner) throws Exception; //delete �궘�젣 public
	void delete(int planner_id) throws Exception;
	//count
	public int count() throws Exception; //selectOne �쉶�썝李얘린 public User
	
	public Planner selectOne(int planner_id) throws Exception; 
	
	public List<Top3Vo> selectAll() throws Exception;
	
	public List<Top3Vo> selectTop3() throws Exception;

	public Planner loginUser(String account_id, String password) throws Exception;
	

	int saveReviewImage(Review_Image image) throws Exception;

	int saveReview(Planner_Review review) throws Exception;

	public List<Planner_Review> getReviewDetail(int plannerId);

	List<Review_Image> getReviewImages(int reviewId) throws Exception;

	public String getUserAccountName(int user_id);


	public List<Top3Vo> searchByAd(String address) throws Exception;

	public List<Top3Vo> searchByName(String name) throws Exception;

	public List<Top3Vo> searchByGroup(String agency) throws Exception;

	public Page<Planner> getPlanners(Pageable pageable);

	public Planner updateFavoriteStatus(int planner_id, boolean isFavorite) throws Exception;

	public List<Planner_Review> getTop3ReviewsByPlannerId(int planner_id);

	public void insertPlannerLike(Map<String, Object> parameters) throws Exception;
	
	public List<Planner> selectPlannerLike(int user_id) throws Exception;
	
	public void deletePlannerLike(int user_id, int planner_like_id) throws Exception;

	public Planner_Like getPlannerLike(int user_id, int planner_id) throws Exception;
	
	public int updateFavorite(int planner_like_id, boolean isFavorite) throws Exception;
	
	
	public Planner selectOne2(String account_id) throws Exception;

	public List<User> chattingWithSomeone(int planner_id) throws Exception;

}
