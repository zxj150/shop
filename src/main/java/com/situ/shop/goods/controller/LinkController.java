package com.situ.shop.goods.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/link")
public class LinkController implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String PAGE_SHOP_LIST="admain/shop_list";
	private static final String PAGE_SHOP_ADMAIN="admain/shop_admain";

	@RequestMapping("/list")
	public ModelAndView goshoplist(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_SHOP_LIST);
		return modelAndView;
	}
	@RequestMapping("/shopadmain")
	public ModelAndView goshopadmain(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_SHOP_ADMAIN);
		return modelAndView;
	}
}
