package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.People;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		People peo = ac.getBean("peo", People.class);
		People peo2 = ac.getBean("peo", People.class);
		System.out.println(peo==peo2);
		
	}

}
