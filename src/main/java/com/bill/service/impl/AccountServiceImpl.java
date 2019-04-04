package com.bill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill.mapper.AccountMapper;
import com.bill.pojo.Account;
import com.bill.service.AccountService;

import lombok.Data;

@Service
@Transactional
@Data
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public List<Account> findAccountAll() {
		// TODO Auto-generated method stub
		return accountMapper.getAccounts();
	}

	@Override
	public Account findAccountByAId(String a_Id) {
		// TODO Auto-generated method stub
		return accountMapper.findAccountByAId(a_Id);
	}

	/**
	 * 根据账户ID修改账户金额
	 * @param a_Money 待更新金额
	 * @param a_Id 账户ID
	 */
	@Override
	public void updateAccountMoneyById(Double a_Money, String a_Id) {
		// TODO Auto-generated method stub
		accountMapper.updateAccountMoneyById(a_Money, a_Id);
	}

	/**
	 * 根据账户ID修改排序
	 * @param a_Id 账户ID
	 * @param a_Sort 排序序号
	 */
	@Override
	public void updateAccountSort(String a_Id, String a_Sort) {
		accountMapper.updateAccountSortById(a_Id, a_Sort);
	}

}
