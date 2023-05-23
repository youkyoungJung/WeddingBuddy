package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public int insert(User user) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(user);
	}
	
	
  

	/*
	 * @Override public int update(User user) throws Exception { // TODO
	 * Auto-generated method stub return dao.update(user); }
	 * 
	 * @Override public void delete(int user_id) throws Exception { // TODO
	 * Auto-generated method stub dao.delete(user_id); }
	 */

	@Override
	public User loginUser(String account_id, String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("S : 컨트롤러에서 호출받으면 필요한 정보를 받아서 DAO로 전달");
		User returnVO = null;
		try {
			returnVO = dao.readUserWithIDPW(account_id, password);
			System.out.println(returnVO);
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; //실행하다 문제가 생겼을때 해당 데이터를 보내지않겠다는 의미 = 예외처리
		}
		return returnVO; //null이 반환되면 앞의 코드가 문제가 있다는 것을 바로 알수있다.
	}




	/*
	 * @Override public int count() throws Exception { // TODO Auto-generated method
	 * stub return dao.count(); }
	 * 
	 *
	 * 
	 * @Override public List<User> selectAll() throws Exception { // TODO
	 * Auto-generated method stub return dao.selectAll(); }
	 */
	 @Override 
	 public User selectOne(String user_id) throws Exception { 
		 return dao.selectOne(user_id); 
	 }

	@Override
	public List<Planner> chattingWithSomeone(int user_id) throws Exception {
		return dao.chattingWithSomeone(user_id);
	}

}
