package com.situ.shop.address.service;

import java.util.List;

import com.situ.shop.address.domain.Area;

public interface AreaService {
   List<Area> findAll();
   List<Area> findByCode(Integer areaCode);
   String findName(Integer areaCode);
}
