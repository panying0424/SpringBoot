package com.bill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bill.interceptor.UserLogin;

/**
 * 启动程序
 * @author PanYing
 *
 */
@SpringBootApplication
@EnableScheduling//定时器开启
@MapperScan("com.bill.mapper") //扫描mybatis的Mapper接口
public class App implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration userLogin = registry.addInterceptor(new UserLogin());
		userLogin.addPathPatterns("/**");
		userLogin.excludePathPatterns("/user/loginUser");
		userLogin.excludePathPatterns("/user/userLogin");
	}
	
}
