package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Beauty_Salon;
import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Studio;
import com.multicampus.kb03.weddingBuddy.repository.Beauty_SalonDao;
import com.multicampus.kb03.weddingBuddy.repository.DressDao;
import com.multicampus.kb03.weddingBuddy.repository.StudioDao;
@Service
public class Beauty_SalonStudioServiceImpl implements Beauty_SalonService{
	
	@Autowired
	private Beauty_SalonDao dao;
	
	@Override
	public List<Beauty_Salon> getAllBeauty_Salon() {
		return dao.getAllBeauty_Salon();
	}

	@Override
	public List<Company_Image> getCompanyImages(int company_unique_id) {
		return dao.getCompanyImages(company_unique_id);
	}

	@Override
	public List<Company_Image> getImagesByShopId(int beauty_salon_id) {
		return dao.getImagesByShopId(beauty_salon_id);
	}

	@Override
	public Beauty_Salon getBeauty_SalonById(int beauty_salon_id) {
		return dao.getBeauty_SalonById(beauty_salon_id);
	

	}

}
