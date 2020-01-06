package com.situ.shop.list.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.shop.list.domain.Lists;


@Repository
public interface ListDao {
	Long save(Lists lists);
	List<Lists> find();
	void delete(Long rowId);
	void update(Lists lists);
	Lists get(Long rowId);
	Lists getByName(String listName);
}
