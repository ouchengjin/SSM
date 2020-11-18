package com.bjsxt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class DemoBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("我在method2之前执行");
	}


}
