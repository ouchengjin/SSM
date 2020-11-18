package com.bjsxt.sorm.utils;
/**
 * 
 * @ClassName: StringUtils
 * @Description: 封装了字符串常用的操作
 * @author Alan Ouyang
 * @date 2020-06-16 22:21:03
 */
public class StringUtils {
	/**
	 * 将目标字符串首字母变为大写
	 * @param str 目标字符串首字母变为大写的字符串
	 * @return
	 */
	public static String firstChar2UpperCase(String str){
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
