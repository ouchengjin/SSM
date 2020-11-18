package com.bjsxt.sorm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装了反射常用的操作
 * @ClassName: ReflectUtils
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-16 22:22:05
 */
public class ReflectUtils {

	/**
	 * 调用obj对象对应属性fieldName的	get方法
	 * @Title: invokeGet
	 * @param fileName
	 * @param obj
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-19 10:36:16
	 */
	public static Object invokeGet(String fileName,Object obj){
		try {
			Class<? extends Object> c = obj.getClass();
			Method m = c.getDeclaredMethod("get"+StringUtils.firstChar2UpperCase(fileName), null);
			return m.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void  invokeSet(Object rowObj,String columnName,Object columnValue){
		try {
			Method m = rowObj.getClass().getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName), columnValue.getClass());
			m.invoke(rowObj, columnValue);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
