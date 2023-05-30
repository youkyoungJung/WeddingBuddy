package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Studio;

@Mapper
public interface StudioMapper {

	List<Studio> getAllStudioShops();

	List<Company_Image> getCompanyImages(int company_unique_id);

	List<Company_Image> getImagesByShopId(int studio_id);

	Studio getStudioById(int studio_id);

}
