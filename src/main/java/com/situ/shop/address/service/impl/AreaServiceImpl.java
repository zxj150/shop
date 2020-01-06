package com.situ.shop.address.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.shop.address.dao.AreaDao;
import com.situ.shop.address.domain.Area;
import com.situ.shop.address.service.AreaService;
@Service
public class AreaServiceImpl implements Serializable, AreaService {

	private static final long serialVersionUID = 1L;
    @Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> findAll() {
		
		return areaDao.find();
	}
	@Override
	public List<Area> findByCode(Integer areaCode) {
		
		return areaDao.findByCode(areaCode);
	}
	@Override
	public String findName(Integer areaCode) {
		
		return areaDao.findName(areaCode);
	}
	

}
