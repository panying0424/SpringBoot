package com.bill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bill.pojo.Account;

/**
 * 账户Mapper对象
 * @author PanYing
 *
 */
public interface AccountMapper {

	@Select("select a_Id,a_Name,a_Number,a_Money,user_id from account order by a_Sort")
	@Results({@Result(property = "a_Monery_Id", column = "a_Monery_Id",one = @One(select="com.bill.mapper.AccountMapper.findAccountByMoneryId"))})
	public List<Account> findAccountAll();
	
	@Select("select a_Id,a_Name,a_Number,a_Money,user_id from account where a_Id = #{a_Id}")
	public Account findAccountById(String a_Id);
	
	@Select("select * from account where a_Id = #{a_Monery_Id}")
	public Account findAccountByMoneryId(String a_Monery_Id);
	
	@Select("select *  from account  order by a_Sort")
	@Results({
		@Result(column="a_Monery_Id",property="a_Monery_Id",javaType=Account.class,one=@One(select="com.bill.mapper.AccountMapper.findAccountByMoneryId"))
	})
	public List<Account> getAccounts();
	
	@Select("select * from account where a_Id = #{a_Id}")
	@Results({
		@Result(column="a_Monery_Id",property="a_Monery_Id",javaType=Account.class,one=@One(select="com.bill.mapper.AccountMapper.findAccountByMoneryId"))
	})
	public Account findAccountByAId(String a_Id);
	
	@Update(value= {"update account set a_Money = #{a_Money} where a_Id = #{a_Id}"})
	public void updateAccountMoneyById(Double a_Money,String a_Id);
	
	@Update(value= {"update account set a_Sort = #{a_Sort} where a_Id = #{a_Id}"})
	public void updateAccountSortById(String a_Id, String a_Sort);
	
	
}
