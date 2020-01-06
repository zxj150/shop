package com.situ.shop.address.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.shop.address.domain.Address;

@Repository
public interface AddressDao {

	Long save(Address address);

	void delete(Long rowId);

	void update(Address address);

	List<Address> find();

	Address get(Long rowId);
}
