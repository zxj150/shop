package com.situ.shop.goods.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.shop.goods.domain.Shop;

@Repository
public interface ShopDao {
	
	Long saveShop(Shop shop);

	void update(Shop shop);
	
	Shop get(Long rowId);
	
	void delete(Long rowId);

	List<Shop> find();
	
	Shop getByName(String shopName);
	
	List<Shop> findByPage(@Param("searchShop")Shop searchShop,@Param("firstResult") Integer firstResult, @Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchShop")Shop searchShop);
}
