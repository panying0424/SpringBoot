package com.bill.service;

import java.util.List;

import com.bill.pojo.User;

/**
 * 用户业务层
 * @author PanYing
 *
 */
public interface UserService {

	/**
	 * 查询所有用户
	 * @return 用户对象集合
	 */
	public List<User> findUserAll();
	
	/**
	 * 根据用户名和密码查询用户
	 * @param user 用户对象
	 * @return 用户对象
	 */
	public User findUserByUserNameAndPassWord(User user);
	
}
