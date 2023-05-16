package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

@Mapper
public interface PlannerMapper {

	public int insert(Planner planner);

	public int update(Planner planner);

	public void delete(int planner_id);

	public int count();

	public Planner selectOne(int planner_id);

	public List<Planner> selectAll();
	
	public List<Top3Vo> selectTop3();

}
