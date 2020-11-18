package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.Student;

public class Test {
	public static void main(String[] args) {
		ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student bean = as.getBean("stu", Student.class);
		System.out.println(bean);
	}
}
