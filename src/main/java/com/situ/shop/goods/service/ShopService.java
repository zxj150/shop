package com.situ.shop.goods.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.situ.shop.base.PageData;
import com.situ.shop.goods.domain.Shop;

public interface ShopService {
	Long saveShop(HttpServletRequest request, Shop shop);

	Long deleteShop(Long rowId);

	List<Shop> findShop();
	
	Shop findShopById(Long rowId);
	
	Long doUpdate(Shop shop);
	
	Boolean checkShopName(String shopName);

	PageData buildPageData(Integer pageNo, Shop searchShop);

	List<Shop> findByPage(Integer pageNo, Shop searchShop);

}
