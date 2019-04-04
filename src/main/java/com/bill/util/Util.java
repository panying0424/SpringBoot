package com.bill.util;

import java.util.UUID;

/**
 * 账单工具对象
 * @author PanYing
 *
 */
public class Util {

	/**
	 * 获得UUID字符串
	 * @return UUID
	 */
	public static String getUUID() {
		String val = new String(UUID.randomUUID().toString());
		return val;
	}
	
}
