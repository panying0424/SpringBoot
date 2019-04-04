package com.bill.pojo;

import lombok.Data;

/**
 * 用户对象
 * @author PanYing
 *
 */
@Data
public class User {

	/** 用户ID */
	private String u_Id;
	
	/** 用户名 */
	private String u_UserName;
	
	/** 用户密码 */
	private String u_PassWord;

	@Override
	public String toString() {
		return "User [u_Id=" + u_Id + ", u_UserName=" + u_UserName + ", u_PassWord=" + u_PassWord + "]";
	}
	
}
