package com.situ.shop.address.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.shop.address.domain.Address;
import com.situ.shop.address.domain.Area;
import com.situ.shop.address.service.AddressService;
import com.situ.shop.address.service.AreaService;

@Controller
@RequestMapping("/address")
public class AddressController implements Serializable {

	private static final long serialVersionUID = 1L;
     @Autowired
     private AreaService areaSercive;
     @Autowired
     private AddressService addressService;
     @ResponseBody
	@RequestMapping("/findByCode/{code}")
	public List<Area> goUpdate(@PathVariable("code") Integer code) {
		return areaSercive.findByCode(code);
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddRole(Address address) {
		return addressService.saveAddress(address);
	}
	
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.addressService.doDeleteAddress(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Address goUpdate(@PathVariable("rowId") Long rowId) {
		return this.addressService.findAddressById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	public Long doUpdateRolwr(Address address) {
		return this.addressService.doUpdate(address);
	}
}
