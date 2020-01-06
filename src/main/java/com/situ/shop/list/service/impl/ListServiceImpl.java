package com.situ.shop.list.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.shop.list.dao.ListDao;
import com.situ.shop.list.domain.Lists;
import com.situ.shop.list.service.ListService;
import com.situ.shop.util.ContextUtils;


@Service
public class ListServiceImpl implements Serializable, ListService {
	@Autowired
	private ListDao listDao;
	private static final long serialVersionUID = 1L;

	@Override
	public Long saveList(Lists lists) {
		String createBy = null;
		createBy = ContextUtils.getCreateBy();
		lists.setCreateBy(createBy);
		lists.setCreateDate(new Date());
		int group = 0;
		if (lists.getParentListIp() == -1L) {
			group = listDao.find().size() + 1;
		} else {
			List<Lists> menu = new ArrayList<Lists>();
			menu=listDao.find();
			for (int i=0;i<menu.size();i++) {
				Lists value=menu.get(i);
				if (value.getRowId() ==lists.getParentListIp() ) {
					group = value.getListGroup() + 1;
           
				}
				
			}
			
		}

		lists.setListGroup(group);
		listDao.save(lists);
		return 1L;
	}

	@Override
	public List<Lists> findAllList() {

		return listDao.find();
	}

	@Override
	public Long deleteList(Long rowId) {
		listDao.delete(rowId);
		return 1L;
	}

	@Override
	public Long updateList(Lists lists) {
		listDao.update(lists);
		return 1L;
	}

	@Override
	public Lists findListById(Long rowId) {

		return listDao.get(rowId);
	}

	@Override
	public Boolean checkListName(String listName) {
		Lists lists = listDao.getByName(listName);

		Boolean bool = lists != null ? false : true;
		return bool;
	}

}
