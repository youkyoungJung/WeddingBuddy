package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;
import java.util.Map;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;

public interface PlannerService {
	// insert �쉶�썝媛��엯(異붽�/�궫�엯)
	public int insert(Planner planner) throws Exception;

	//update �닔�젙 
	public int update(Planner planner) throws Exception; //delete �궘�젣 public
	void delete(int planner_id) throws Exception;
	//count
	public int count() throws Exception; //selectOne �쉶�썝李얘린 public User
	
	public Planner selectOne(int planner_id) throws Exception; 
	
	public List<Planner> selectAll() throws Exception;
	
	public List<Top3Vo> selectTop3() throws Exception;

	public Planner loginUser(String account_id, String password) throws Exception;
	
	public Planner selectOne2(String account_id) throws Exception;

	public List<User> chattingWithSomeone(int planner_id) throws Exception;

}
