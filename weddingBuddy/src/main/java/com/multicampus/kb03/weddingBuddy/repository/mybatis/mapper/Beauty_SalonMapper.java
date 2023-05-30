package com.multicampus.kb03.weddingBuddy.repository.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multicampus.kb03.weddingBuddy.dto.Beauty_Salon;
import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;

@Mapper
public interface Beauty_SalonMapper {

	List<Beauty_Salon> getAllBeauty_Salon();

	List<Company_Image> getCompanyImages(int company_unique_id);

	List<Company_Image> getImagesByShopId(int beauty_salon_id);

	Beauty_Salon getBeauty_SalonById(int beauty_salon_id);

}
