package com.bjsxt.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	public void method1(){
		System.out.println("method1");
	}
	@Pointcut(value="execution(* com.bjsxt.test.Demo.method2(..))")
	public void method2(){
//		int a=1/0;
		System.out.println("method2");
	}
	public void method3(){
		System.out.println("method3");
	}
	public void method4(String name){
		System.out.println(name);
	}
}
