package com.situ.shop.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController2 {

	@RequestMapping(path={"/","/index"})
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("/shop/index");
		return modelAndView;
	}
}
