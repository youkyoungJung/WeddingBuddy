package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Planner;


import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;

import com.multicampus.kb03.weddingBuddy.dto.Planner_Like;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.repository.PlannerDao;

import com.multicampus.kb03.weddingBuddy.repository.UserDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.PlannerMapper;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.UserMapper;

@Repository
public class MyBatisPlannerDao implements PlannerDao {

	@Autowired
	private PlannerMapper mapper;

	@Override
	public int insert(Planner planner) throws Exception {
		return mapper.insert(planner);
	}

	@Override
	public int update(Planner planner) throws Exception {
		return mapper.update(planner);
	}

	@Override
	public void delete(int planner_id) throws Exception {
		mapper.delete(planner_id);
	}

	@Override
	public int count() throws Exception {
		return mapper.count();
	}

	@Override
	public Planner selectOne(int planner_id) throws Exception {
		return mapper.selectOne(planner_id);
	}

	@Override
	public List<Top3Vo> selectAll() throws Exception {
		return mapper.selectAll();
	}

	@Override
	public List<Top3Vo> selectTop3() throws Exception {
		return mapper.selectTop3();
	}

	@Override
	public int insertReview(Planner_Review review) {
		return mapper.insertReview(review);
	}

	@Override
	public int saveReviewImage(Review_Image image) {
		return mapper.saveReviewImage(image);
	}

	@Override
	public List<Planner_Review> getReviewDetail(int plannerId) {
		return mapper.getReviewDetail(plannerId);
	}

	@Override
	public List<Review_Image> getReviewImages(int reviewId) throws Exception {
		return mapper.getReviewImages(reviewId);
	}

	@Override
	public String getUserAccountName(int user_id) {
		return mapper.getUserAccountName(user_id);
	}

	@Override
	public List<Planner> searchByAd(String address) throws Exception {
	public List<Top3Vo> searchByAd(String address) throws Exception {
		// TODO Auto-generated method stub
		return mapper.searchByAd(address);
	}
	

	@Override
	public List<Top3Vo> searchByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return mapper.searchByName(name);
	}

	@Override
	public List<Top3Vo> searchByGroup(String agency) throws Exception {
		// TODO Auto-generated method stub
		return mapper.searchByGroup(agency);
	}

	@Override
	public Page<Planner> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planner updateFavoriteStatus(int planner_id, boolean isFavorite) throws Exception {
		return mapper.updateFavoriteStatus(planner_id, isFavorite);
	}

	@Override
	public List<Planner> selectPlannerLike(int user_id) throws Exception {
		return mapper.selectPlannerLike(user_id);
	}
	
	@Override
	public void deletePlannerLike(int user_id, int planner_id) {
		mapper.deletePlannerLike(user_id, planner_id);
	}
  @Override
	public Planner readUserWithIDPW(String account_id, String password) throws Exception {
		return mapper.readUserWithIDPW(account_id, password);
	}

	@Override
	public Planner selectOne2(String account_id) throws Exception {
		return mapper.selectOne2(account_id);
	}

	@Override
	public List<User> chattingWithSomeone(int planner_id) throws Exception {
		return mapper.chattingWithSomeone(planner_id);
	}
  @Override
	public List<Planner_Review> getTop3ReviewsByPlannerId(int planner_id) {
		return mapper.getTop3ReviewsByPlannerId(planner_id);
	public void insertPlannerLike(Map<String, Object> parameters) {
		mapper.insertPlannerLike(parameters);
	}

	@Override
	public Planner_Like getPlannerLike(int user_id, int planner_id) throws Exception {
		return mapper.getPlannerLike(user_id, planner_id);
	}

	@Override
	public int updateFavorite(int planner_like_id, boolean isFavorite) throws Exception {
		// TODO Auto-generated method stub
		return mapper.updateFavorite(planner_like_id, isFavorite);
	}

	 

}
