package com.situ.shop.list.service;

import java.util.List;

import com.situ.shop.list.domain.Lists;


public interface ListService {
	Long saveList(Lists lists);
	List<Lists> findAllList();
	Long deleteList(Long roeId);
	Long updateList(Lists lists);
	Lists findListById(Long roeId);
	Boolean checkListName(String listName);
}
