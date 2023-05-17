package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;

public interface PlannerService {
	// insert 회원가입(추가/삽입)
	public int insert(Planner planner) throws Exception;

	//update 수정 
	public int update(Planner planner) throws Exception; //delete 삭제 public
	void delete(int planner_id) throws Exception;
	//count
	public int count() throws Exception; //selectOne 회원찾기 public User
	
	public Planner selectOne(int planner_id) throws Exception; //selectAll 회원전체보기 public List<User>
	
	public List<Planner> selectAll() throws Exception;
	
	public List<Top3Vo> selectTop3() throws Exception;
	
}
