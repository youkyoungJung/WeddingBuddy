package com.multicampus.kb03.weddingBuddy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.SqlSession;


import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Review;
import com.multicampus.kb03.weddingBuddy.dto.Review_Image;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.repository.PlannerDao;
import com.multicampus.kb03.weddingBuddy.repository.UserDao;

@Service
public class PlannerServiceImpl implements PlannerService {
	

	@Autowired
	private PlannerDao dao;
	
	@Override
	public int insert(Planner planner) throws Exception {
		return dao.insert(planner);
	}

	@Override
	public int update(Planner planner) throws Exception {
		return dao.update(planner);
	}

	@Override
	public void delete(int planner_id) throws Exception {
		dao.delete(planner_id);
	}

	@Override
	public int count() throws Exception {
		return dao.count();
	}

	@Override
	public Planner selectOne(int planner_id) throws Exception {
		return dao.selectOne(planner_id);
	}

	@Override
	public List<Planner> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public List<Top3Vo> selectTop3() throws Exception {
		return dao.selectTop3();
	}
	
	@Override
    public int saveReview(Planner_Review review) throws Exception {
        // 리뷰 정보를 데이터베이스에 저장하는 로직 구현
        // 예시로 dao.insertReview(review)를 호출한다고 가정
        return dao.insertReview(review);
    }

    @Override
    public int saveReviewImage(Review_Image image) throws Exception {
        // 이미지 정보를 데이터베이스에 저장하는 로직 구현
        // 예시로 dao.insertReviewImage(image)를 호출한다고 가정
        return dao.saveReviewImage(image);
    }

	@Override
	public List<Planner_Review> getReviewDetail(int plannerId) {
		return dao.getReviewDetail(plannerId);
	}

	

	

}
