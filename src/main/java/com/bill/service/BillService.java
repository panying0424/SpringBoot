package com.bill.service;

import java.util.List;

import com.bill.pojo.Bill;

/**
 * 账单业务接口
 * @author PanYing
 *
 */
public interface BillService {

	/**
	 * 获得所有账单对象
	 * @return List<账单对象> 集合
	 */
	public List<Bill> findBillAll();
	
	/**
	 * 根据账单ID 获取账单对象
	 * @param b_Id 账单ID
	 * @return 账单对象 {@link Bill}
	 */
	public Bill findBillById(String b_Id);
	
	public boolean addToUpdateBill(Bill bill);
	
	public List<Bill> findBill(String account,String budget);
	
	public List<Bill> findBill(String account,String budget,String startDate,String endDate);
	
}
