package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.repository.UserDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.UserMapper;

@Repository
public class MyBatisUserDao implements UserDao {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public int insert(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.insert(user);
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(user);
	}

	@Override
	public void delete(int user_id) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(user_id);

	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return mapper.count();
	}

	@Override
	public User selectOne(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectOne(user_id);
	}

	@Override
	public List<User> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}
