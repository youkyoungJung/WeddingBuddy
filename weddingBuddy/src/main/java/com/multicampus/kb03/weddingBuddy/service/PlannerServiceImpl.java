package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

	@Override
	public List<Review_Image> getReviewImages(int reviewId) throws Exception {
	    return dao.getReviewImages(reviewId);
	}

	@Override
	public String getUserAccountName(int user_id) {
		return dao.getUserAccountName(user_id);
	}


	

	@Override
	public List<Planner> searchByAd(String address) throws Exception {
		return dao.searchByAd(address);
	}

	@Override
	public List<Planner> searchByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByName(name);
	}

	@Override
	public List<Planner> searchByGroup(String agency) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByGroup(agency);
	}
	
	@Override
	public Page<Planner> getPlanners(Pageable pageable){
		return dao.findAll(pageable);
	}

	@Override
	public Planner updateFavoriteStatus(int planner_id, boolean isFavorite) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPlannerLike(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Planner_Review> getTop3ReviewsByPlannerId(int planner_id) {
		// TODO Auto-generated method stub
		return dao.getTop3ReviewsByPlannerId(planner_id);
	}


	
	
	

	
	
}
