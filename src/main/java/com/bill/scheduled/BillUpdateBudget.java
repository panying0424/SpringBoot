package com.bill.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 更改账单收支
 * @author PanYing
 *
 */
@Component
public class BillUpdateBudget {

	/**
	 * 定时方法
	 * 设置定时任务
	 * 在启动器中开启
	 * cron=cron表达式 秒 分 小时 月份日期 月份 星期中的日期
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void scheduledMethod() {
		System.out.println("定时器触发"+new Date());
	}

	
}
