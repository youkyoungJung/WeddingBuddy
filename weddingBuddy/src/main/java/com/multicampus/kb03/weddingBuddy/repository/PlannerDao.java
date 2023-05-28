package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

public interface PlannerDao {
	public int insert(Planner planner) throws Exception;

	public int update(Planner planner) throws Exception;

	public void delete(int planner_id) throws Exception;

	public int count() throws Exception;

	public Planner selectOne(int planner_id) throws Exception;
	
	public Planner selectOne2(String account_id) throws Exception;

	public List<Planner> selectAll() throws Exception;

	public List<Top3Vo> selectTop3() throws Exception;
	

	public int insertReview(Planner_Review review);
	
	public int saveReviewImage(Review_Image image);
	
	public List<Planner_Review> getReviewDetail(int plannerId);
	
	public List<Review_Image> getReviewImages(int reviewId) throws Exception;
	
	public String getUserAccountName(int user_id);
	public Planner readUserWithIDPW(String account_id, String password) throws Exception;

	public List<User> chattingWithSomeone(int planner_id) throws Exception;

	

	public List<Planner> searchByAd(String address) throws Exception;
	
	public List<Planner> searchByName(String name) throws Exception;
	
	public List<Planner> searchByGroup(String agency) throws Exception;
	
	public Page<Planner> findAll(Pageable pageable);
	
	public Planner updateFavoriteStatus(int planner_id, boolean isFavorite) throws Exception;
	
	public List<Planner_Review> getTop3ReviewsByPlannerId(int planner_id);
	
	
	
	
	

}