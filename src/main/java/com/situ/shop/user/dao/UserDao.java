package com.situ.shop.user.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.shop.user.domain.User;

@Repository
public interface UserDao {
	Long saveUser(User user);

	void update(User user);
	
	void delete(Long rowId);

	//List<User> findUser();
	
	User get(Long rowId);
	
	User getUser(@Param("user")User user);
	
	User getUser2(@Param("user2")User user);

	List<User> find();

	List<User> findByPage(@Param("searchUser")User searchRole,@Param("firstResult") Integer firstResult, @Param("maxResults") Integer maxResults);

	User getByName(String roleName);

	Integer getCount(@Param("searchUser")User searchRole);


}
