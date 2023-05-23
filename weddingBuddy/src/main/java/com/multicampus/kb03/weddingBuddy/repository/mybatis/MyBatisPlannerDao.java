package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
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
	public List<Planner> selectAll() throws Exception {
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

	 

}
