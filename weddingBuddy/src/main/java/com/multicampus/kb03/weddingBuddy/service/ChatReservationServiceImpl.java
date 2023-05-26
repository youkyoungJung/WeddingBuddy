package com.multicampus.kb03.weddingBuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.ChatReservation;
import com.multicampus.kb03.weddingBuddy.repository.ChatReservationDao;

@Service
public class ChatReservationServiceImpl implements ChatReservationService {

	@Autowired
	ChatReservationDao dao;
	
	@Override
	public boolean reservationExist(int planner_id, String reservation_date) throws Exception {
		int cnt = dao.reservationExist(planner_id, reservation_date);
		if (cnt > 0)
			return true;
		return false;
	}

	@Override
	public void insertReservation(int chatting_id, String reservation_date) {
		dao.insertReservation(chatting_id, reservation_date);
	}

	@Override
	public String selectNextReservedDatetime(int chatting_id) {
		return dao.selectNextReservedDatetime(chatting_id);
	}

}
