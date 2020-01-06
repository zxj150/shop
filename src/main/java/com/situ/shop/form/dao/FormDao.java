package com.situ.shop.form.dao;

import org.springframework.stereotype.Repository;

import com.situ.shop.form.domain.Form;
@Repository
public interface FormDao {

	Long save(Form form);
}
