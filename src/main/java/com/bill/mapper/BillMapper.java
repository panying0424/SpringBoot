package com.bill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bill.pojo.Account;
import com.bill.pojo.Bill;

/**
 * 账单Mapper对象
 * @author PanYing
 *
 */
public interface BillMapper {

	/**
	 * 获得所有账单对象
	 * @return List<账单对象> 集合
	 */
	@Select("select * from bill order by b_time desc")
	@Results({
		@Result(column="account_id",property="b_account",javaType=Account.class,one=@One(select="com.bill.mapper.AccountMapper.findAccountById"))
	})
	public List<Bill> findBillAll();
	
	/**
	 * 根据账单ID 获取账单对象
	 * @param a_Id 账单ID
	 * @return 账单对象 Bill
	 */
	@Select("select * from bill where b_Id = #{b_Id}")
	@Results({
		@Result(column="account_id",property="b_account",javaType=Account.class,one=@One(select="com.bill.mapper.AccountMapper.findAccountById"))
	})
	public Bill findBillById(String b_Id);
	
	@Insert(value = {"insert into bill values(#{b_Id},#{b_time},#{b_describe},#{b_money},#{b_balance},#{b_account.a_Id},#{b_budget})"})
	public void insertBill(Bill bill);
	
	
	
	@Update(value = {"update bill set b_money = #{b_money},b_budget = #{b_budget},b_describe = #{b_describe},account_id = #{b_account.a_Id} where b_Id = #{b_Id}"})
	public void updateBill(Bill bill);
	
	@Select("select * from bill where account_id like #{account} and b_budget like #{budget}")
	@Results({
		@Result(column="account_id",property="b_account",javaType=Account.class,one=@One(select="com.bill.mapper.AccountMapper.findAccountById"))
	})
	public List<Bill> findBill(String account,String budget);
	
	@Select("select * from bill where account_id like #{account} and b_budget like #{budget} and b_time >= #{startDate} and b_time <= #{endDate}")
	@Results({
		@Result(column="account_id",property="b_account",javaType=Account.class,one=@One(select="com.bill.mapper.AccountMapper.findAccountById"))
	})
	public List<Bill> findBilla(String account,String budget,String startDate,String endDate);
	
	public List<Bill> findBill(String account,String budget,String startDate,String endDate);
	
	
	
	
	
}
