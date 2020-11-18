package com.bjsxt.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Mishu implements MethodInterceptor{

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("预约时间");
		//调用父类的方法，将父类对象和参数传进去
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("记录信息");
		return result;
	}

	

	
}
