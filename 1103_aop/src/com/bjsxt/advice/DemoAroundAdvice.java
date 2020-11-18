package com.bjsxt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DemoAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("方法执行前做点事");
		mi.proceed();
		System.out.println("方法执行后做点事");
		return null;
	}

}
