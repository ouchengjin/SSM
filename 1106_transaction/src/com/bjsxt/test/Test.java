package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import com.bjsxt.service.impl.UsersServiceImpl;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersService usersServiceImpl = ac.getBean("usersService", UsersServiceImpl.class);
		Users users = new Users();
		users.setUname("wangwu");
		users.setUpwd("6786786w8");
		int result = usersServiceImpl.insUsers(users);
		if (result>0) {
			System.out.println("成功");
		}else{
			System.out.println("失败");
			
		}
	}

}
