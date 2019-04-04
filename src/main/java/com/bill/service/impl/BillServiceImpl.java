package com.bill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill.mapper.BillMapper;
import com.bill.pojo.Account;
import com.bill.pojo.Bill;
import com.bill.service.AccountService;
import com.bill.service.BillService;
import com.bill.util.Util;

import lombok.Data;

/**
 * 账单业务层
 * @author PanYing
 *
 */
@Service
@Transactional
@Data
public class BillServiceImpl implements BillService {

	@Autowired
	private BillMapper billMapper;
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 获得所有账单对象
	 * @return List<账单对象> 集合
	 */
	@Override
	public List<Bill> findBillAll() {
		// TODO Auto-generated method stub
		return billMapper.findBillAll();
	}

	/**
	 * 根据账单ID 获取账单对象
	 * @param b_Id 账单ID
	 * @return 账单对象 {@link Bill}
	 */
	@Override
	public Bill findBillById(String b_Id) {
		// TODO Auto-generated method stub
		return billMapper.findBillById(b_Id);
	}
	
	public boolean addToUpdateBill(Bill bill) {
		//根据收支 修改金额
		Account account = accountService.findAccountByAId(bill.getB_account().getA_Id());
		if(account != null) {//账户是否真实存在
			bill.setB_account(account);
			if(bill.getB_Id().equals("-1")) {//-1代表添加账单页面传入过来的 (创建新账单)
				bill.setB_Id(Util.getUUID());
				
				if(account.getA_Monery_Id() == null) {//没有共享资金账户
					Double temp_Money = new Double(0.0);
					if(bill.getB_budget().equals(bill.INCOME)) {
						temp_Money= account.getA_Money()+bill.getB_money();
					}else if(bill.getB_budget().equals(bill.EXPENDITURE)){
						temp_Money= account.getA_Money()-bill.getB_money();
					}
					 
					bill.setB_balance(temp_Money);
					accountService.updateAccountMoneyById(temp_Money, account.getA_Id());
				}else {
					Account account_A = accountService.findAccountByAId(account.getA_Monery_Id().getA_Id());
					if(account_A != null) {
						Double temp_Money = new Double(0.0);
						if(bill.getB_budget().equals(bill.INCOME)) {
							temp_Money= account_A.getA_Money()+bill.getB_money();
						}else if(bill.getB_budget().equals(bill.EXPENDITURE)){
							temp_Money= account_A.getA_Money()-bill.getB_money();
						}
						bill.setB_balance(temp_Money);
						
						accountService.updateAccountMoneyById(temp_Money, account_A.getA_Id());
					}
				}
				
				billMapper.insertBill(bill);

			}else {
				Bill nbill = billMapper.findBillById(bill.getB_Id());
				nbill.setB_money(bill.getB_money());
				nbill.setB_budget(bill.getB_budget());//收支不可更改
				nbill.setB_describe(bill.getB_describe());
				nbill.setB_account(bill.getB_account());
				billMapper.updateBill(nbill);
			}
			
		return true;
		}
		return false;
	}

	@Override
	public List<Bill> findBill(String account, String budget, String startDate, String endDate) {
		return billMapper.findBilla(account, budget, startDate, endDate);
	}

	@Override
	public List<Bill> findBill(String account, String budget) {
		return billMapper.findBill(account, budget);
	}

}
