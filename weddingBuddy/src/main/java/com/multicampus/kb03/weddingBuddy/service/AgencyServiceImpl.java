package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Agency;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.repository.AgencyDao;
import com.multicampus.kb03.weddingBuddy.repository.PlannerDao;
import com.multicampus.kb03.weddingBuddy.repository.UserDao;

@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyDao dao;
	
	@Override
	public int insert(Agency agency) throws Exception {
		return dao.insert(agency);
	}

	@Override
	public int update(Agency agency) throws Exception {
		return dao.update(agency);
	}

	@Override
	public void delete(int agency_id) throws Exception {
		dao.delete(agency_id);
	}

	@Override
	public int count() throws Exception {
		return dao.count();
	}

	@Override
	public Agency selectOne(int agency_id) throws Exception {
		return dao.selectOne(agency_id);
	}

	@Override
	public List<Agency> selectAll() throws Exception {
		return dao.selectAll();
	}

}
