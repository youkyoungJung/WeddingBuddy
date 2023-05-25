package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.multicampus.kb03.weddingBuddy.dto.ChatReservation;

@Mapper
public interface ChatReservationMapper {

	public int reservationExist(@Param("planner_id") int planner_id, @Param("reservation_date") String reservation_date);

}
