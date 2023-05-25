package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import com.multicampus.kb03.weddingBuddy.dto.Agency;
import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;

public interface AgencyService {
	// insert 
	public int insert(Agency agency) throws Exception;

	//update 수정 
	public int update(Agency agency) throws Exception; //delete 삭제 public
	void delete(int agency_id) throws Exception;
	//count
	public int count() throws Exception; //selectOne public User
	
	public Agency selectOne(int agency_id) throws Exception; //selectAll  public List<User>
	
	public List<Agency> selectAll() throws Exception;
	
}
