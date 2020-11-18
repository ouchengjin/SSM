package com.bjsxt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class DemoAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("我在method2后执行");
	}

}
