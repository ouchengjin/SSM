package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
		String[] names = as.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
