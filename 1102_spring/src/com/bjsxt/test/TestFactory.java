package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.factory.PeopleFactory;
import com.bjsxt.factory.PeopleFactory2;
import com.bjsxt.pojo.People;

public class TestFactory {

	public static void main(String[] args) {
//		System.out.println(new PeopleFactory().getInstance());
		ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
		People bean= as.getBean("people", People.class);
		System.out.println(bean);
//		System.out.println(PeopleFactory2.getInstance());
	}

}
