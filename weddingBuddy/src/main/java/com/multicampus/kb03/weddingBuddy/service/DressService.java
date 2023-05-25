package com.multicampus.kb03.weddingBuddy.service;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;

public interface DressService {

	List<Dress_Shop> getAllDressShops();

	List<Company_Image> getCompanyImages(int company_unique_id);

}
