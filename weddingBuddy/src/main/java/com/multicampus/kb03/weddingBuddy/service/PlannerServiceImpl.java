package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
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

}
