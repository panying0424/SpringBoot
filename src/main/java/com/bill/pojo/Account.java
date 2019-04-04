package com.bill.pojo;

import lombok.Data;

/**
 * 账户对象
 * @author PanYing
 *
 */
@Data
public class Account {
	
	/** ID */
	private String a_Id;
	
	/** 账户名称 */
	private String a_Name;
	
	/** 账户账号  */
	private String a_Number;
	
	/** 账户金额 */
	private Double a_Money;
	
	/** 账户余额关联 账户ID */
	private Account a_Monery_Id;
	
	/** 排序 */
	private Integer a_Sort;

	@Override
	public String toString() {
		return "Account [a_Id=" + a_Id + ", a_Name=" + a_Name + ", a_Number=" + a_Number + ", a_Money=" + a_Money
				+ ", a_Monery_Id=" + a_Monery_Id + ", a_Sort=" + a_Sort + "]";
	}

}
