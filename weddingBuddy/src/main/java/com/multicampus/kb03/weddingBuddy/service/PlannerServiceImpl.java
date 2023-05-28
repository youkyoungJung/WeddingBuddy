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
import com.multicampus.kb03.weddingBuddy.dto.Planner_Like;
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
	public List<Top3Vo> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public List<Top3Vo> selectTop3() throws Exception {
		return dao.selectTop3();
	}
	
	@Override
	public Planner loginUser(String account_id, String password) throws Exception {
		// TODO Auto-generated method stub
		Planner returnVO = null;
		try {
			returnVO = dao.readUserWithIDPW(account_id, password);
			System.out.println(returnVO);
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; 
		}
		return returnVO; 
	}

	@Override
	public Planner selectOne2(String account_id) throws Exception {
		return dao.selectOne2(account_id);
	}

	@Override
	public List<User> chattingWithSomeone(int planner_id) throws Exception {
		return dao.chattingWithSomeone(planner_id);
	}


	@Override
    public int saveReview(Planner_Review review) throws Exception {
        // 由щ럭 �젙蹂대�� �뜲�씠�꽣踰좎씠�뒪�뿉 ���옣�븯�뒗 濡쒖쭅 援ы쁽
        // �삁�떆濡� dao.insertReview(review)瑜� �샇異쒗븳�떎怨� 媛��젙
        return dao.insertReview(review);
    }

    @Override
    public int saveReviewImage(Review_Image image) throws Exception {
        // �씠誘몄� �젙蹂대�� �뜲�씠�꽣踰좎씠�뒪�뿉 ���옣�븯�뒗 濡쒖쭅 援ы쁽
        // �삁�떆濡� dao.insertReviewImage(image)瑜� �샇異쒗븳�떎怨� 媛��젙
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
	public List<Top3Vo> searchByAd(String address) throws Exception {
		return dao.searchByAd(address);
	}

	@Override
	public List<Top3Vo> searchByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByName(name);
	}

	@Override
	public List<Top3Vo> searchByGroup(String agency) throws Exception {
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
	public void insertPlannerLike(Map<String, Object> parameters) throws Exception {
		dao.insertPlannerLike(parameters);
		
	}

	@Override
	public List<Planner> selectPlannerLike(int user_id) throws Exception {
		return dao.selectPlannerLike(user_id);
	}

	@Override
	public void deletePlannerLike(int user_id, int planner_id) throws Exception {
		dao.deletePlannerLike(user_id, planner_id);
		
	}

	@Override
	public List<Planner_Review> getTop3ReviewsByPlannerId(int planner_id) {
		// TODO Auto-generated method stub
		return dao.getTop3ReviewsByPlannerId(planner_id);
	}

	public Planner_Like getPlannerLike(int user_id, int planner_id) throws Exception {
		return dao.getPlannerLike(user_id, planner_id);
	}

	@Override
	public int updateFavorite(int planner_like_id, boolean isFavorite) throws Exception {
		return dao.updateFavorite(planner_like_id, isFavorite);
	}

	
	
	

	
	
}
