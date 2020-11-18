package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class DemoAdvice {
	/**
	 * 前置通知
	 * @Title: beforeDemo
	 * @author Alan Ouyang
	 * @date 2020-07-20 18:05:12
	 */
	@Before("com.bjsxt.test.Demo.method2()")
	public void beforeDemo(){
		System.out.println("前置通知");
	}
	/**
	 * 后置通知
	 * @Title: afterDemo
	 * @author Alan Ouyang
	 * @date 2020-07-20 18:16:13
	 */
	@AfterReturning("com.bjsxt.test.Demo.method2()")
	public void afterDemo(){
		System.out.println("后置通知");
	}
	/**
	 * 异常通知
	 * @Title: exceptionDemo
	 * @author Alan Ouyang
	 * @date 2020-07-20 18:17:12
	 */
	@AfterThrowing("com.bjsxt.test.Demo.method2()")
	public void exceptionDemo(){
		System.out.println("异常通知");
	}
	/**
	 * 环绕通知
	 * @Title: aroundAdvice
	 * @param p
	 * @return
	 * @throws Throwable
	 * @author Alan Ouyang
	 * @date 2020-07-20 19:46:48
	 */
	@Around("com.bjsxt.test.Demo.method2()")
	public Object aroundAdvice(ProceedingJoinPoint p) throws Throwable{
		System.out.println("环绕通知前");
		Object result = p.proceed();//切点方法的执行
		System.out.println("环绕通知后");
		return result;
	}
}
