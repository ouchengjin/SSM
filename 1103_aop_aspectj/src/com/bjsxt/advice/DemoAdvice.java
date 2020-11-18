package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class DemoAdvice {
	/**
	 * 前置通知
	 * @Title: beforeDemo
	 * @author Alan Ouyang
	 * @date 2020-07-20 18:05:12
	 */
	public void beforeDemo(){
		System.out.println("前置通知");
	}
	/**
	 * 后置通知
	 * @Title: afterDemo
	 * @author Alan Ouyang
	 * @date 2020-07-20 18:16:13
	 */
	public void afterDemo(){
		System.out.println("后置通知");
	}
	/**
	 * 异常通知
	 * @Title: exceptionDemo
	 * @author Alan Ouyang
	 * @date 2020-07-20 18:17:12
	 */
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
	public Object aroundAdvice(ProceedingJoinPoint p) throws Throwable{
		System.out.println("环绕通知前");
		Object result = p.proceed();//切点方法的执行
		System.out.println("环绕通知前");
		return result;
	}
}
