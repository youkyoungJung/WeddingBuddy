package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Planner_Like;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;

public interface PlannerDao {
	// insert 회원가입(추가/삽입)
	public int insert(Planner planner) throws Exception;
	//update 수정 
	public int update(Planner planner) throws Exception;
	// delete 삭제 
	public void delete(int planner_id) throws Exception;
	// count 
	public int count() throws Exception;
	// selectOne 회원찾기 
	public Planner selectOne(int planner_id) throws Exception;
	// selectAll 회원전체보기 
	public List<Top3Vo> selectAll() throws Exception;
	//top3
	public List<Top3Vo> selectTop3() throws Exception;
	

	public List<Top3Vo> searchByAd(String address) throws Exception;
	
	public List<Top3Vo> searchByName(String name) throws Exception;
	
	public List<Top3Vo> searchByGroup(String agency) throws Exception;
	
	public Page<Planner> findAll(Pageable pageable);
	
	public Planner updateFavoriteStatus(int planner_id, boolean isFavorite) throws Exception;
	
	public List<Planner> selectPlannerLike(int user_id) throws Exception;
	
	public void deletePlannerLike(int user_id, int planner_id) throws Exception;
	
	public void insertPlannerLike(Map<String, Object> parameters)throws Exception;
	
	//Planner like id 가져옴
	public Planner_Like getPlannerLike(int user_id, int planner_id) throws Exception;
	
	public int updateFavorite(int planner_like_id, boolean isFavorite) throws Exception;

	
	
	

}