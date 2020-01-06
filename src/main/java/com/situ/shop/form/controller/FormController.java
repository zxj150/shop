package com.situ.shop.form.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.shop.form.domain.Form;
import com.situ.shop.form.service.FormService;

@Controller
@RequestMapping("/form")
public class FormController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static final String PAGE_FORM_INDEX="form/form_index";
	private static final String PAGE_FORM_LIST="form/form_list";
	
	@RequestMapping("/index")
	public ModelAndView goFormIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_FORM_INDEX);
		return modelAndView;
	}
	@RequestMapping("/list")
	public ModelAndView goFormList(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_FORM_LIST);
		return modelAndView;
	}
	
	@Autowired
	private FormService formService;
	
	@RequestMapping("save")
	public Long save(Form form) {
		return formService.saveForm(form);
	}
	
	
	
	
}
