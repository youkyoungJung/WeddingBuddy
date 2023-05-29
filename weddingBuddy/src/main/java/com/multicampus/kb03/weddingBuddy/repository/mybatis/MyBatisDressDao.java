package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.repository.DressDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.DressMapper;
@Repository
public class MyBatisDressDao implements DressDao{
	@Autowired
	private DressMapper mapper;
	@Override
	public List<Dress_Shop> getAllDressShops() {
		return mapper.getAllDressShops();
	}
	@Override
	public List<Company_Image> getCompanyImages(int company_unique_id) {
		return mapper.getCompanyImages(company_unique_id);
	}
	@Override
	public List<Company_Image> getImagesByShopId(int dress_shop_id) {
		return mapper.getImagesByShopId(dress_shop_id);
	}
	@Override
	public Dress_Shop getDressShopById(int dress_shop_id) {
		return mapper.getDressShopById(dress_shop_id);
	}

}
