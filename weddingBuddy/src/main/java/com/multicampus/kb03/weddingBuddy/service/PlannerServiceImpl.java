package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
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
	public Planner_Like getPlannerLike(int user_id, int planner_id) throws Exception {
		return dao.getPlannerLike(user_id, planner_id);
	}

	@Override
	public int updateFavorite(int planner_like_id, boolean isFavorite) throws Exception {
		return dao.updateFavorite(planner_like_id, isFavorite);
	}

	
	
	

	
	
}
