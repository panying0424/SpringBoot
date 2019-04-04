package com.bill.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bill.pojo.User;
import com.bill.service.UserService;

import lombok.Data;

@Controller
@RequestMapping("/user")
@Data
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	@RequestMapping("/users/{page}")
	public String showPage1(@PathVariable String page) {
		System.out.println(page);
		return page;
	}
	
	@RequestMapping("/")
	public String index(Model model,HttpServletResponse response) {
	    return "/index";
	}
	
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model) {
		List<User> list = this.userService.findUserAll();
		model.addAttribute("users",list);
		return "users/showUsers";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/loginUser")
	public String findUserByNameAndPassWord(String urlStr,String u_UserName,String u_PassWord,Model model,HttpServletRequest request,HttpSession session) {
		User user = new User();
		user.setU_UserName(u_UserName);
		user.setU_PassWord(u_PassWord);
		User resultUser = this.userService.findUserByUserNameAndPassWord(user);
		//String referer = request.getHeader("REFERER");
		
		if(resultUser == null) {
			model.addAttribute("errorTip", "用户名或密码错误");
			return "/userLogin";
		}else {
			session.setAttribute("user", resultUser);
			return "redirect:"+urlStr;
		}
		
		
	}
	
}
