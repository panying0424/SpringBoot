package com.bill.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.pojo.Account;
import com.bill.pojo.User;
import com.bill.service.AccountService;

import lombok.Data;

@Controller
@RequestMapping("/account")
@Data
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	@RequestMapping("/account/{page}")
	public String showPage1(@PathVariable String page) {
		System.out.println(page);
		return page;
	}
	
	@PostMapping(value="findAccountAll")
	@ResponseBody
	public List<Account> findAccountAll() {
		List<Account> accounts =  accountService.findAccountAll();
		return accounts;
	}
	
	@RequestMapping("/findAccountAllList")
	public String findAccountAll(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Account> accounts =  accountService.findAccountAll();
		model.addAttribute("accounts", accounts);
		return "account/showAccount";
	}
	
	@RequestMapping("/updateSort")
	public String updateSort(String[] a_Id,String[] a_Sort,Model model) {
		for(int i = 0; i < a_Id.length;i++) {
			accountService.updateAccountSort(a_Id[i], a_Sort[i]);
		}
		return "redirect:/account/findAccountAllList";
	}

}
