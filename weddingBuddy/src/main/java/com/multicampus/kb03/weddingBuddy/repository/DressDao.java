package com.multicampus.kb03.weddingBuddy.repository;

import java.util.List;

import com.multicampus.kb03.weddingBuddy.dto.Company_Image;
import com.multicampus.kb03.weddingBuddy.dto.Dress_Shop;

public interface DressDao {

	List<Dress_Shop> getAllDressShops();

	List<Company_Image> getCompanyImages(int company_unique_id);

	List<Company_Image> getImagesByShopId(int dress_shop_id);

	Dress_Shop getDressShopById(int dress_shop_id);

}
