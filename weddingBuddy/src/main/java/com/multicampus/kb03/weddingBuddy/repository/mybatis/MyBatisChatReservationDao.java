package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.repository.ChatReservationDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.ChatReservationMapper;

@Repository
class MyBatisChatReservationDao implements ChatReservationDao {

	@Autowired
	private ChatReservationMapper chatReservationMapper;
	
	@Override
	public int reservationExist(int planner_id, String reservation_date) throws Exception {
		return chatReservationMapper.reservationExist(planner_id, reservation_date);
	}

	@Override
	public void insertReservation(int chatting_id, String reservation_date) {
		chatReservationMapper.insertReservation(chatting_id, reservation_date);
	}

	@Override
	public String selectNextReservedDatetime(int chatting_id) {
		return chatReservationMapper.selectNextReservedDatetime(chatting_id);
	}

}
