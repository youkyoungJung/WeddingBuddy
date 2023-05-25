package com.multicampus.kb03.weddingBuddy.service;

import com.multicampus.kb03.weddingBuddy.dto.ChatReservation;

public interface ChatReservationService {
	
	public boolean reservationExist(int planner_id, String reservation_date) throws Exception; 
		
}
