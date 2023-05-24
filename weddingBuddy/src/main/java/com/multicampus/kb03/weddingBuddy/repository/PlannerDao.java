package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;
import java.util.Map;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;

public interface PlannerDao {
	// insert 회원가입(추가/삽입)
	public int insert(Planner planner) throws Exception;
	//update 수정 
	public int update(Planner planner) throws Exception;
	// delete 삭제 
	public void delete(int planner_id) throws Exception;
	// count 
	public int count() throws Exception;
	// selectOne 회원찾기 
	public Planner selectOne(int planner_id) throws Exception;
	// selectAll 회원전체보기 
	public List<Planner> selectAll() throws Exception;
	//top3
	public List<Top3Vo> selectTop3() throws Exception;
	
	public int insertReview(Planner_Review review);
	
	public int saveReviewImage(Review_Image image);
	
	public List<Planner_Review> getReviewDetail(int plannerId);
	
	public List<Review_Image> getReviewImages(int reviewId) throws Exception;
	
	public String getUserAccountName(int user_id);


}
