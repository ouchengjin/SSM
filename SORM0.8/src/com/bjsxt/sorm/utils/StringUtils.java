package com.bjsxt.sorm.utils;
/**
 * 封装了字符串常用的操作
 * @ClassName: StringUtils
 * @author Alan Ouyang
 * @date 2020-06-21 17:52:19
 */
public class StringUtils {
	/**
	 * 目标字符串首字母变为大写的字符串
	 * @Title: firstChar2UpperCase
	 * @param str
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-21 17:50:43
	 */
	public static String firstChar2UpperCase(String str){
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
