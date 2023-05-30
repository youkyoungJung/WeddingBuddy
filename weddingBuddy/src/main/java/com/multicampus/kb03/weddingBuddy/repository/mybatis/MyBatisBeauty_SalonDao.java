package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Beauty_Salon;
import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Studio;
import com.multicampus.kb03.weddingBuddy.repository.Beauty_SalonDao;
import com.multicampus.kb03.weddingBuddy.repository.StudioDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.Beauty_SalonMapper;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.StudioMapper;
@Repository
public class MyBatisBeauty_SalonDao implements Beauty_SalonDao{
	@Autowired
	private Beauty_SalonMapper mapper;
	@Override
	public List<Beauty_Salon> getAllBeauty_Salon() {
		return mapper.getAllBeauty_Salon();
	}
	@Override
	public List<Company_Image> getCompanyImages(int company_unique_id) {
		return mapper.getCompanyImages(company_unique_id);
	}
	@Override
	public List<Company_Image> getImagesByShopId(int beauty_salon_id) {
		return mapper.getImagesByShopId(beauty_salon_id);
	}
	@Override
	public Beauty_Salon getBeauty_SalonById(int beauty_salon_id) {
		return mapper.getBeauty_SalonById(beauty_salon_id);
	}


}
