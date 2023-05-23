package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Agency;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.repository.AgencyDao;
import com.multicampus.kb03.weddingBuddy.repository.PlannerDao;
import com.multicampus.kb03.weddingBuddy.repository.UserDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.AgencyMapper;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.PlannerMapper;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.UserMapper;

@Repository
public class MyBatisAgencyDao implements AgencyDao {

	@Autowired
	private AgencyMapper mapper;

	@Override
	public int insert(Agency agency) throws Exception {
		return mapper.insert(agency);
	}

	@Override
	public int update(Agency agency) throws Exception {
		return mapper.update(agency);
	}

	@Override
	public void delete(int agency_id) throws Exception {
		mapper.delete(agency_id);
	}

	@Override
	public int count() throws Exception {
		return mapper.count();
	}

	@Override
	public Agency selectOne(int agency_id) throws Exception {
		return mapper.selectOne(agency_id);
	}

	@Override
	public List<Agency> selectAll() throws Exception {
		return mapper.selectAll();
	}

}
