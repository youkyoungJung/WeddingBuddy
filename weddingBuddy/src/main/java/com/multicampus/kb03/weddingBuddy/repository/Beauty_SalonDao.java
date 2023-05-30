package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Beauty_Salon;
import com.multicampus.kb03.weddingBuddy.dto.Company_Image;

public interface Beauty_SalonDao {

	List<Beauty_Salon> getAllBeauty_Salon();

	List<Company_Image> getCompanyImages(int company_unique_id);

	List<Company_Image> getImagesByShopId(int dress_shop_id);

	Beauty_Salon getBeauty_SalonById(int beauty_salon_id);

}
