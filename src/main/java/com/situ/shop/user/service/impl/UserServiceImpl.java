package com.situ.shop.user.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.shop.base.PageData;
import com.situ.shop.user.dao.UserDao;
import com.situ.shop.user.domain.User;
import com.situ.shop.user.service.UserService;
import com.situ.shop.util.MD5Utils;
import com.situ.shop.util.PageUtils;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 管理员登录
	 * @param request
	 * @param user
	 * @return
	 */
	@Override
	public Integer login(HttpServletRequest request,User user) {
		User user_return=null;
		Integer result=0;
		try {
			user.setUserPass(MD5Utils.encode(user.getUserPass()));
			user_return = userDao.getUser(user);
			if(user_return!=null){
			result=1;
			String ip = InetAddress.getLocalHost().getHostAddress();
			user_return.setLastIp(ip);
			user_return.setLastTime(new Date());
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(60*60*60*30);
			session.setAttribute("user_return",user_return);
			System.out.println(session.getAttribute("user_return"));
				/* userDao.update(user_return); */
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Integer login2(HttpServletRequest request,User user) {
		User user_return=null;
		Integer result=0;
		try {
			user.setUserPass(MD5Utils.encode(user.getUserPass()));
			user_return = userDao.getUser2(user);
			if(user_return!=null){
				result=1;
			String ip = InetAddress.getLocalHost().getHostAddress();
			user_return.setLastIp(ip);
			user_return.setLastTime(new Date());
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(60*60*60*30);
			session.setAttribute("user_return",user_return);
			
			System.out.println(session.getAttribute("user_return"));
				/* userDao.update(user_return); */
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public Long saveUser(User user) {
		
			try {
				user.setLastIp(InetAddress.getLocalHost().getHostAddress());
				user.setUserPass(MD5Utils.encode(user.getUserPass()));
				user.setCreateBy("zxj");
				user.setCreateDate(new Date());
				user.setLock(0);
				user.setUserClazz(1);
				user.setActiveFlag(1);
				user.setLastTime(new Date());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return userDao.saveUser(user);
	}
	@Override
	public List<User> findUser() {
		return userDao.find();
	}

	@Override
	public List<User> findByPage(Integer pageNo, User searchUser) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * 5;
		// limit查询数据 要显示的条数
		Integer maxResults = 5;
		return userDao.findByPage(searchUser, firstResult, maxResults);
	}

	@Override
	public User findUserById(Long rowId) {
		return userDao.get(rowId);
	}

	@Override
	public Long doUpdate(User user) {
		
		try {
			user.setUpdateBy("zxj");
			user.setUpdateDate(new Date());
			user.setUserClazz(1);
			user.setLastIp(InetAddress.getLocalHost().getHostAddress());
			user.setLastTime(new Date());
			userDao.update(user);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return user.getRowId();
	}

	@Override
	public Long deleteUser(Long rowId) {
		userDao.delete(rowId);
		return rowId;
	}

	@Override
	public Boolean checkUserName(String userName) {
		// 根据角色名称查询实例
		User role = userDao.getByName(userName);
		// 三元表达式，如果有返回false，如果没有返回true
		Boolean bool = role != null ? false : true;
		return bool;
	}

	@Override
	public PageData buildPageData(Integer pageNo, User searchUser) {
		// 查询出数据总数
		Integer dataCount =userDao.getCount(searchUser);
		return PageUtils.buildPageData(dataCount, pageNo);
	}


}
