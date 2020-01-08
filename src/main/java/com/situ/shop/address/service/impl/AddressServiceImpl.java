package com.situ.shop.address.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.shop.address.dao.AddressDao;
import com.situ.shop.address.domain.Address;
import com.situ.shop.address.service.AddressService;
@Service
public class AddressServiceImpl implements Serializable, AddressService {

	private static final long serialVersionUID = 1L;

	  @Autowired
		private AddressDao addressDao;
		@Override
		public Long saveAddress(Address address) {
			address.setActiveFlag(1);
			return addressDao.save(address);
		}

		@Override
		public List<Address> find() {
			
			return addressDao.find();
		}

		@Override
		public List<Address> findByPage(Integer pageNo, Address searchAddress) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Address findAddressById(Long rowId) {
			
			return addressDao.get(rowId);
		}

		@Override
		public Long doUpdate(Address address) {
			addressDao.update(address);
			return 1L;
		}

		@Override
		public Long doDeleteAddress(Long rowId) {
			addressDao.delete(rowId);
			return 1L;
		}

}
