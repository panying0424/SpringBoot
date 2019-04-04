package com.bill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill.mapper.UserMapper;
import com.bill.pojo.User;
import com.bill.service.UserService;

import lombok.Data;

/**
 * 
 * @author PanYing
 *
 */
@Service
@Transactional
@Data
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询所有用户
	 * @return 所有用户集合
	 */
	@Override
	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return this.userMapper.findUsers();
	}

	/**
	 * 根据用户名和密码查询用户
	 * @param user 用户对象
	 * @return 用户对象
	 */
	@Override
	public User findUserByUserNameAndPassWord(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.findUserByUserNameAndPassWord(user);
	}
	
	

}
