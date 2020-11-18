package com.bjsxt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {	
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo = ac.getBean("demo", Demo.class);
		Demo2 demo2 =  ac.getBean("demo2", Demo2.class);
		demo.method1();
		demo.method2();
		demo.method3();
		demo.method4("method4");
		demo2.method1();
		demo2.method2();
		demo2.method3();
		demo2.method4("");
	}

}
