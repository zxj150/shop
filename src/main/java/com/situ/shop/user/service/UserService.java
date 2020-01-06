package com.situ.shop.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.situ.shop.base.PageData;
import com.situ.shop.user.domain.User;

public interface UserService {

	Long saveUser(User user);
	
	Long deleteUser(Long rowId);

	List<User> findUser();
	
	List<User> findByPage(Integer pageNo, User searchUser);
	
	User findUserById(Long rowId);
	
	Long doUpdate(User user);
	
	Boolean checkUserName(String userName);
	
	PageData buildPageData(Integer pageNo,User searchUser);

	Integer login(HttpServletRequest request, User user);

	Integer login2(HttpServletRequest request, User user);
}
