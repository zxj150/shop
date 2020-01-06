package com.situ.shop.user.controller;

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
import com.situ.shop.user.domain.User;
import com.situ.shop.user.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_USER = "user/user_index";
	private static final String PAGE_LIST_USER = "user/user_list";
	@Autowired
	private UserService userService;
	/**
	 * 用户注册
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Long saveUser(User user) {
		return userService.saveUser(user);
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/findUser") public List<User> findUser() {
	 * 
	 * return userService.findUser(); }
	 */
	@ResponseBody
	@RequestMapping("/userIndex")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_USER);
		return modelAndView;
	}
	/**
	 * @查询所有的记录
	 * @param pageNo       分页的页号
	 * @param modelAndView
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAlluser(@PathVariable Integer pageNo, User searchuser, ModelAndView modelAndView) {
		// 要展示的列表数据
		modelAndView.addObject("userList", userService.findByPage(pageNo,searchuser));
		// 分页信息
		modelAndView.addObject("pageData", userService.buildPageData(pageNo,searchuser));
		modelAndView.setViewName(PAGE_LIST_USER);
		return modelAndView;
	}

	// user/goupdate?rowId=1
	// user/goupdate/1
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public User goUpdate(@PathVariable("rowId") Long rowId) {
		return this.userService.findUserById(rowId);
	}

	@ResponseBody
	@RequestMapping("/doupdate")
	public Long doUpdateUser(User user) {
		return this.userService.doUpdate(user);
	}

	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.userService.deleteUser(rowId);
	}
	/**
	 * 管理员 登录
	 * @param fieldId
	 * @param fieldValue
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAdmainlogin")
	public Integer doadmainlogin(HttpServletRequest request,User user) {
		return userService.login(request, user);
	}
	/**
	 * 用户登录
	 * @param fieldId
	 * @param fieldValue
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dologin")
	public Integer dologin(HttpServletRequest request,User user) {
		return userService.login2(request, user);
	}
	@ResponseBody
	@RequestMapping("/checkuserName")
	public String checkuserName(String fieldId, String fieldValue) {
		// 通过服务层判断此名称是否可以使用。true：可以使用，false：不可以使用
		Boolean bool = userService.checkUserName(fieldValue);
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
	
	@RequestMapping("/goAdmainLogin")
	public String goAdmainLogin() {
		return "admain/admain";
	}

}
