package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
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
	
	
	
	/*
	 * @Override public int update(User user) throws Exception { // TODO
	 * Auto-generated method stub return mapper.update(user); }
	 * 
	 * @Override public void delete(int user_id) throws Exception { // TODO
	 * Auto-generated method stub mapper.delete(user_id);
	 * 
	 * }
	 */

	/*
	 * @Override public int count() throws Exception { // TODO Auto-generated method
	 * stub return mapper.count(); }
	 * 
	 * 
	 * 
	 * @Override public List<User> selectAll() throws Exception { // TODO
	 * Auto-generated method stub return mapper.selectAll(); }
	 */

	@Override
	public User readUserWithIDPW(String account_id, String password) throws Exception {
		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * map.put("account_id", account_id); map.put("password", password);
		 */

		// return mapper.readUserWithIDPW(map);
		return mapper.readUserWithIDPW(account_id, password);
	}

	@Override
	public User selectOne(String user_id) throws Exception {
		return mapper.selectOne(user_id);
	}

	@Override
	public List<Planner> chattingWithSomeone(int user_id) throws Exception {
		return mapper.chattingWithSomeone(user_id);
	}



	@Override
	public int selectUserIdByAccountId(String accountId) {
		return mapper.selectUserIdByAccountId(accountId);
	}

}
