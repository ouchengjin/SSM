package com.bjsxt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Mishu implements InvocationHandler{
	private Laoban laoban = new Laoban();

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("秘书查询预约");
		Object result = method.invoke(laoban, args);
		
		System.out.println("秘书记录信息");
		return result;
	}

	
}
