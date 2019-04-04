package com.bill.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.pojo.Account;
import com.bill.pojo.Bill;
import com.bill.service.BillService;
import com.bill.util.Util;

import lombok.Data;

/**
 * 账单视图处理对象
 * 
 * @author PanYing
 *
 */
@Controller
@RequestMapping("/bill")
@Data
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping("findBillAll")
	public String findBillAll(Model model) {
		List<Bill> bills = billService.findBillAll();
		model.addAttribute("bills", bills);
		return "showBills";
	}

	@RequestMapping("findBillById")
	public String findBillById(String b_Id, Model model) {
		Bill bill = billService.findBillById(b_Id);
		model.addAttribute("bill", bill);
		return "billDetailed";
	}

	@PostMapping(value = "findBillBudget")
	@ResponseBody
	public Bill findBillBudget() {
		Bill bill = new Bill();
		bill.setB_time(new Date());
		bill.setB_budget(Bill.EXPENDITURE);
		return bill;
	}

	@RequestMapping("addToBill")
	public String addToBill(Model model) {
		Bill bill = new Bill();
		bill.setB_Id("-1");
		bill.setB_time(new Date());
		bill.setB_describe("");
		bill.setB_money(0.0);
		bill.setB_budget(bill.EXPENDITURE);
		bill.setB_balance(0.0);
		bill.setB_account(new Account());
		model.addAttribute("bill", bill);
		return "billDetailed";
	}

	@RequestMapping("/updateBill")
	public String updateBill(String b_Id, String b_money, String budget, String account, String b_describe,Model model) {
		if (b_Id != "" && b_money != "" && budget != "" && account != "" && b_describe != "" && !b_money.equals("-1")
				&& !b_Id.trim().equals("") && !b_money.trim().equals("") && !budget.trim().equals("")
				&& !account.trim().equals("") && !b_describe.trim().equals("")) {
			if (budget.equals(Bill.INCOME) || budget.equals(Bill.EXPENDITURE)) {
				Bill bill = new Bill();
				bill.setB_Id(b_Id);
				bill.setB_time(new Date());
				bill.setB_describe(b_describe);
				bill.setB_money(Double.valueOf(b_money));
				if(budget.equals(Bill.INCOME)) {
					bill.setB_budget(Bill.INCOME);
				}else if(budget.equals(Bill.EXPENDITURE)) {
					bill.setB_budget(Bill.EXPENDITURE);
				}
				bill.setB_balance(0.0);
				Account account2 = new Account();
				account2.setA_Id(account);
				bill.setB_account(account2);
				model.addAttribute("bill", bill);
				if (billService.addToUpdateBill(bill)) {
					return "redirect:/bill/findBillAll";
				}
			}
		}
		
		return "billDetailed";
	}
	
	
	@RequestMapping("/conditionQuery")
	public String conditionQuery(String account,String budget,String startDate,String endDate,Model model) {
		
		if(account != null && budget != null && startDate != null && endDate != null) {
			
			if(account.trim().equals("-1")) {
				account = "%";
			}
			
			if(budget.trim().equals("-1")) {
				budget = "%";
			}
			
			
			if(startDate.trim().equals("") || endDate.trim().equals("")) {
				List<Bill> bill = billService.findBill(account, budget);
				model.addAttribute("bills", bill);
			}else {
				List<Bill> bill = billService.findBill(account, budget, startDate, endDate);
				model.addAttribute("bills", bill);
			}
			return "showBills";
		}
		
		return "redirect:/bill/findBillAll";
	}
	


}
