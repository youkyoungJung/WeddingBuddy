package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;
import java.util.Map;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

public interface PlannerDao {
	public int insert(Planner planner) throws Exception;

	public int update(Planner planner) throws Exception;

	public void delete(int planner_id) throws Exception;

	public int count() throws Exception;

	public Planner selectOne(int planner_id) throws Exception;
	
	public Planner selectOne2(String account_id) throws Exception;

	public List<Planner> selectAll() throws Exception;

	public List<Top3Vo> selectTop3() throws Exception;

	public Planner readUserWithIDPW(String account_id, String password) throws Exception;

	public List<User> chattingWithSomeone(int planner_id) throws Exception;

}
