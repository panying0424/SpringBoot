package com.bill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bill.pojo.User;

/**
 * 用户Mapper对象
 * @author PanYing
 *
 */
public interface UserMapper {

	/**
	 * 查询所有用户对象
	 * @return 用户对象集合
	 */
	@Select(value = {"select u_Id,u_UserName,u_PassWord from user"})
	public List<User> findUsers();
	
	@Select(value = {"select u_Id,u_UserName,u_PassWord from user where u_UserName = #{u_UserName} and u_PassWord = #{u_PassWord}"})
	public User findUserByUserNameAndPassWord(User user);
	
	
	
}
