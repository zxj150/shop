package com.situ.shop.address.service;

import java.util.List;

import com.situ.shop.address.domain.Address;

public interface AddressService {
	Long saveAddress(Address address);

	List<Address> find();

	List<Address> findByPage(Integer pageNo, Address searchAddress);

	Address findAddressById(Long rowId);

	Long doUpdate(Address address);

	Long doDeleteAddress(Long rowId);

}
