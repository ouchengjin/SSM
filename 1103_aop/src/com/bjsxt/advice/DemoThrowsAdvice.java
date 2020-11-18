package com.bjsxt.advice;

import org.springframework.aop.ThrowsAdvice;

public class DemoThrowsAdvice implements ThrowsAdvice {
	 public void afterThrowing(Exception e) throws Throwable {
	       System.out.println("异常发生了");
	    }

}
