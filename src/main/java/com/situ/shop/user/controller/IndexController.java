package com.situ.shop.user.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.shop.address.service.AddressService;
import com.situ.shop.address.service.AreaService;
import com.situ.shop.user.domain.User;
import com.situ.shop.user.service.UserService;

@Controller
public class IndexController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_LOGIN_SHOP = "shop/login";
	private static final String PAGE_LIST_SHOP = "shop/udai_order";
	private static final String PAGE_SHOPCART_SHOP = "shop/udai_shopcart";
	private static final String PAGE_SHOW_SHOP = "shop/item_show";
	private static final String PAGE_LOGIN_ADMAIN="admain/admain";
	private static final String PAGE_INDEX_ROLE = "admain/role_index";
	private static final String PAGE_LIST_ROLE = "admain/role_list";
	private static final String PAGE_ADMAIN = "admain/admain_index";
	private static final String PAGE_INDEX = "shop/index";
	
	private static final String PAGE_ADDRESS_INDEX = "address/udai_address";
	@Autowired
	private UserService userService;
	
	  @Autowired
	 private AreaService areaSercive;
	 @Autowired
	 private AddressService addressService;
	@RequestMapping("/address")
	public ModelAndView goaddress(ModelAndView modelAndView) {
		modelAndView.addObject("areaList", areaSercive.findAll());
		modelAndView.addObject("addressList", addressService.find());
		modelAndView.setViewName(PAGE_ADDRESS_INDEX);
		return modelAndView;
	}
	
	/**
	 * 管理员
	 */
	
	@RequestMapping("/admain")
	public ModelAndView goadmain(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_ADMAIN);
		return modelAndView;
	}
	@RequestMapping("/index2")
	public ModelAndView goindex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX);
		return modelAndView;
	}
	@RequestMapping("/index")
	public ModelAndView goadmainIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_ROLE);
		return modelAndView;
	}
	
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllRole(@PathVariable Integer pageNo, User searchShop, ModelAndView modelAndView) {
		// 要展示的列表数据
		modelAndView.addObject("roleList", userService.findByPage(pageNo,searchShop));
		// 分页信息
		modelAndView.addObject("pageData", userService.buildPageData(pageNo,searchShop));
		modelAndView.setViewName(PAGE_LIST_ROLE);
		return modelAndView;
	}
/**
 * 进首页
 */

	
	/**
	 * 登录
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView gologin(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_LOGIN_SHOP);
		return modelAndView;
	}
	/**
	 * 管理登录页面
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/admainlogin")
	public ModelAndView admainlogin(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_LOGIN_ADMAIN);
		return modelAndView;
	}
	/**
	 * 进订单页面
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/order")
	public ModelAndView goList(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_LIST_SHOP);
		return modelAndView;
	}
	
	
	/**
	 * 购物车
	 */
	@RequestMapping("/udai_shopcart")
	public ModelAndView goshopcart(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_SHOPCART_SHOP);
		return modelAndView;
	}
	/**
	 * 商品介绍
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/item_show")
	public ModelAndView goshow(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_SHOW_SHOP);
		return modelAndView;
	}
}
