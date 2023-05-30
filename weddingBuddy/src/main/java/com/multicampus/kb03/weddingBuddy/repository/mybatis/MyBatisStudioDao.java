package com.multicampus.kb03.weddingBuddy.repository.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Studio;
import com.multicampus.kb03.weddingBuddy.repository.StudioDao;
import com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper.StudioMapper;
@Repository
public class MyBatisStudioDao implements StudioDao{
	@Autowired
	private StudioMapper mapper;
	@Override
	public List<Studio> getAllStudioShops() {
		return mapper.getAllStudioShops();
	}
	@Override
	public List<Company_Image> getCompanyImages(int company_unique_id) {
		return mapper.getCompanyImages(company_unique_id);
	}
	@Override
	public List<Company_Image> getImagesByShopId(int studio_id) {
		return mapper.getImagesByShopId(studio_id);
	}
	@Override
	public Studio getStudioById(int studio_id) {
		return mapper.getStudioById(studio_id);
	}

}
