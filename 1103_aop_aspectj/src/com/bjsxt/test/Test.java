package com.bjsxt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {	
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo = ac.getBean("demo", Demo.class);
		demo.method1();
		demo.method2();
		demo.method3();
		demo.method4("method4");
	}

}
