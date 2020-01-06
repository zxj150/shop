package com.situ.shop.form.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.shop.form.dao.FormDao;
import com.situ.shop.form.domain.Form;
import com.situ.shop.form.service.FormService;
@Service
public class FormServiceImpl implements Serializable, FormService {
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private FormDao formDao;
	@Override
	public Long saveForm(Form form) {
		return formDao.save(form);
	}

}
