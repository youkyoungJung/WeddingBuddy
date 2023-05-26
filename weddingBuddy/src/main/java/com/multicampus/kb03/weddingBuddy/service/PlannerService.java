package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;

public interface PlannerService {
	// insert 회원가입(추가/삽입)
	public int insert(Planner planner) throws Exception;

	//update 수정 
	public int update(Planner planner) throws Exception; //delete 삭제 public
	void delete(int planner_id) throws Exception;
	//count
	public int count() throws Exception; //selectOne 회원찾기 public User
	
	public Planner selectOne(int planner_id) throws Exception; //selectAll 회원전체보기 public List<User>
	
	public List<Planner> selectAll() throws Exception;
		// TODO Auto-generated method stub
	
	
	public List<Top3Vo> selectTop3() throws Exception;
	

	int saveReviewImage(Review_Image image) throws Exception;

	int saveReview(Planner_Review review) throws Exception;

	public List<Planner_Review> getReviewDetail(int plannerId);

	List<Review_Image> getReviewImages(int reviewId) throws Exception;

	public String getUserAccountName(int user_id);



	public List<Planner> searchByAd(String address) throws Exception;

	public List<Planner> searchByName(String name) throws Exception;

	public List<Planner> searchByGroup(String agency) throws Exception;

	Page<Planner> getPlanners(Pageable pageable);

	public Planner updateFavoriteStatus(int planner_id, boolean isFavorite) throws Exception;

	public void insertPlannerLike(Map<String, Object> parameters);

	
	

	

	
	
}
