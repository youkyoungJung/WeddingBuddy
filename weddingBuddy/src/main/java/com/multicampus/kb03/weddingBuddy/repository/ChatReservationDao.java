package com.multicampus.kb03.weddingBuddy.repository;

import com.multicampus.kb03.weddingBuddy.dto.ChatReservation;

public interface ChatReservationDao {
		public int reservationExist(int planner_id, String reservation_date) throws Exception;

		public void insertReservation(int chatting_id, String reservation_date);

		public String selectNextReservedDatetime(int chatting_id);
}
