package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Studio;
import com.multicampus.kb03.weddingBuddy.repository.DressDao;
import com.multicampus.kb03.weddingBuddy.repository.StudioDao;
@Service
public class StudioServiceImpl implements StudioService{
	
	@Autowired
	private StudioDao dao;
	
	@Override
	public List<Studio> getAllStudioShops() {
		return dao.getAllStudioShops();
	}

	@Override
	public List<Company_Image> getCompanyImages(int company_unique_id) {
		return dao.getCompanyImages(company_unique_id);
	}

	@Override
	public List<Company_Image> getImagesByShopId(int studio_id) {
		return dao.getImagesByShopId(studio_id);
	}

	@Override
	public Studio getStudioById(int Studio_id) {
		return dao.getStudioById(Studio_id);
	}

}
