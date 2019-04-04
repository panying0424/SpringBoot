package com.bill.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Bill {
	
	/** 收入 */
	public static final String INCOME = "16f36585-045d-40be-99e5-0d023701642d";
	
	/** 支出 */
	public static final String EXPENDITURE= "9373082a-0302-49ec-9ecd-62bbf3cc3fc1";

	/** ID */
	private String b_Id;
	
	/** 交易时间 */
	private Date b_time;
	
	/** 描述 */
	private String b_describe;
	
	/** 交易金额 */
	private Double b_money;
	
	/** 收支 */
	private String b_budget;
	
	/** 交易后余额 */
	private Double b_balance;
	
	/** 账户 */
	private Account b_account;
	
	/**
	 * 获取时间转换为字符串
	 * @return 字符串时间
	 */
	public String getB_timer() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String timeFormat = sdf.format(this.b_time);
		return timeFormat;
	}
	
	/**
	 * 获取当前对象 收入/支出的ID
	 * @return ID
	 */
	public String getB_budgetr() {
		if(this.b_budget.equals(Bill.INCOME)) {
			return "收入";
		}else if(this.b_budget.equals(Bill.EXPENDITURE)){
			return "支出";
		}
		return "N/V";
	}
	
	/**
	 * 获取收入ID
	 * @return ID
	 */
	@SuppressWarnings("static-access")
	public String getIncome() {
		return this.INCOME;
	}
	
	/**
	 * 获取支出ID
	 * @return ID
	 */
	@SuppressWarnings("static-access")
	public String getExpenditure() {
		return this.EXPENDITURE;
	}
	

	@Override
	public String toString() {
		return "Bill [b_Id=" + b_Id + ", b_time=" + b_time + ", b_describe=" + b_describe + ", b_money=" + b_money
				+ ", b_budget=" + b_budget + ", b_balance=" + b_balance + ", b_account=" + b_account + "]";
	}
	
}
