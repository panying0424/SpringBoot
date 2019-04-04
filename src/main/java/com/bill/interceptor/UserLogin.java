package com.bill.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bill.pojo.User;

/**
 * 登录拦截器
 * @author PanYing
 *
 */
public class UserLogin implements HandlerInterceptor {

	/**
	 * 执行 preHandle 方法，该方法会返回一个布尔值。如果为 fa se ，则结束所有流程：如果为 true则执行下一步。
	 * 开始进入请求地址拦截--- 从session获取数据如果存在就放行不存在就抛出异常拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user != null) {
			return true;
		}
//		String strUrlvalue = "";
//		Enumeration  strUrl = request.getHeaders("REFERER");
//		if(strUrl.hasMoreElements()) {
//			strUrlvalue = (String) strUrl.nextElement();
//			System.out.println(strUrlvalue);
//		}else {
//			strUrlvalue = request.getHeader("REFERER");
//		}
//		String[] strUrls = strUrlvalue.split(":8080");
		response.sendRedirect(request.getContextPath()+"/user/userLogin?urlStr="+request.getRequestURI());
		//request.getRequestDispatcher("/user/userLogin").forward(request, response);
		return false;
	}
	
	/**
	 * 处理请求完成后视图渲染之前的处理操作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	/**
	 * 视图渲染之后的操作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
