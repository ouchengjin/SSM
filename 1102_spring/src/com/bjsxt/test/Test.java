package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.People;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		People bean = ac.getBean("people", People.class);
		System.out.println(bean);
		//用于获取spring容器中所有管理的错对象的名字
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanname : beanDefinitionNames) {
			System.out.println(beanname);
		}
		int beanDefinitionCount = ac.getBeanDefinitionCount();
		System.out.println(beanDefinitionCount);
		
	}

}
