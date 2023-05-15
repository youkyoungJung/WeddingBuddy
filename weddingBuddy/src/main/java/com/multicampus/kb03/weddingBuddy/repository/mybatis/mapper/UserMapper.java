package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.multicampus.kb03.weddingBuddy.dto.User;

@Mapper
public interface UserMapper {

	public int insert(User user);

	/*
	 * public int update(User user);
	 * 
	 * public void delete(int user_id);
	 * 
	 * public int count();
	 * 
	 * public User selectOne(int user_id);
	 * 
	 * public List<User> selectAll();
	 */
	
	public User readUserWithIDPW(@Param("account_id")String account_id, @Param("password")String password);

}
