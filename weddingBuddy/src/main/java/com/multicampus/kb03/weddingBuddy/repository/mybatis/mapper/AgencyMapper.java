package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.multicampus.kb03.weddingBuddy.dto.Agency;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

@Mapper
public interface AgencyMapper {

	public int insert(Agency agency);

	public int update(Agency agency);

	public void delete(int agency_id);

	public int count();

	public Agency selectOne(int agency_id);

	public List<Agency> selectAll();
	
}
