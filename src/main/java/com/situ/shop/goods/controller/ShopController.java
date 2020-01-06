package com.situ.shop.goods.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.shop.goods.domain.Shop;
import com.situ.shop.goods.service.ShopService;
@Controller
@RequestMapping("/shop")
public class ShopController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String PAGE_LIST_SHOP="admain/shop_list";
	@Autowired
	private ShopService shopService;
	/**
	 * 商品添加
	 * @param shop
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Long saveUser(HttpServletRequest request,Shop shop) {
		return shopService.saveShop(request,shop);
	}
	@ResponseBody
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllShop(@PathVariable Integer pageNo, Shop searchShop, ModelAndView modelAndView) {
		// 要展示的列表数据
		  modelAndView.addObject("shopList", shopService.findByPage(pageNo,searchShop));
		// 分页信息
		  modelAndView.addObject("pageData", shopService.buildPageData(pageNo,searchShop));
		 
		modelAndView.setViewName(PAGE_LIST_SHOP);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.shopService.deleteShop(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Shop goUpdate(@PathVariable("rowId") Long rowId) {
		return this.shopService.findShopById(rowId);
	}

	@ResponseBody
	@RequestMapping("/doupdate")
	public Long doUpdateShop(Shop shop) {
		return this.shopService.doUpdate(shop);
	}
	
	@ResponseBody
	@RequestMapping("/checkshopName")
	public String checkshopName(String fieldId, String fieldValue) {
		// 通过服务层判断此名称是否可以使用。true：可以使用，false：不可以使用
		Boolean bool = shopService.checkShopName(fieldValue);
		// [String,Boolean] ["userName",true]
		// 通过使用ObjectMapper开始封装需要返回的校验结果
		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		list.add(bool);
		try {
			// 将封装好的校验结果转换成json格式的字符串并响应回去
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
