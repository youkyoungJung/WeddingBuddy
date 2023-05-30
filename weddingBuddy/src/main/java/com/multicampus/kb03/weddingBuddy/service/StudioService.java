package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;
import com.multicampus.kb03.weddingBuddy.dto.Studio;

public interface StudioService {

	List<Studio> getAllStudioShops();

	List<Company_Image> getCompanyImages(int company_unique_id);

	List<Company_Image> getImagesByShopId(int studio_id);

	Studio getStudioById(int studio_id);


}
