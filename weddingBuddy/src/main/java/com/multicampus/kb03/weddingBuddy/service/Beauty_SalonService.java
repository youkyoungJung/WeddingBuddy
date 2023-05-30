package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Beauty_Salon;
import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Studio;

public interface Beauty_SalonService {

	List<Beauty_Salon> getAllBeauty_Salon();

	List<Company_Image> getCompanyImages(int company_unique_id);

	List<Company_Image> getImagesByShopId(int beauty_salon_id);

	Beauty_Salon getBeauty_SalonById(int beauty_salon_id);


}
