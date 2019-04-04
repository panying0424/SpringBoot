package com.bill.service;

import java.util.List;

import com.bill.pojo.Account;

public interface AccountService {

	public List<Account> findAccountAll();
	
	public Account findAccountByAId(String a_Id);
	
	/**
	 * 根据账户ID修改账户金额
	 * @param a_Money 待更新金额
	 * @param a_Id 账户ID
	 */
	public void updateAccountMoneyById(Double a_Money,String a_Id);
	
	/**
	 * 根据账户ID修改排序
	 * @param a_Id 账户ID
	 * @param a_Sort 排序序号
	 */
	public void updateAccountSort(String a_Id,String a_Sort);
	
}
