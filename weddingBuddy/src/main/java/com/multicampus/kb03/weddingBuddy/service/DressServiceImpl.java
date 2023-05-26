package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.repository.DressDao;
@Service
public class DressServiceImpl implements DressService{
	
	@Autowired
	private DressDao dao;
	
	@Override
	public List<Dress_Shop> getAllDressShops() {
		return dao.getAllDressShops();
	}

	@Override
	public List<Company_Image> getCompanyImages(int company_unique_id) {
		return dao.getCompanyImages(company_unique_id);
	}

	@Override
	public List<Company_Image> getImagesByShopId(int dress_shop_id) {
		return dao.getImagesByShopId(dress_shop_id);
	}

	@Override
	public Dress_Shop getDressShopById(int dress_shop_id) {
		return dao.getDressShopById(dress_shop_id);
	}

}
