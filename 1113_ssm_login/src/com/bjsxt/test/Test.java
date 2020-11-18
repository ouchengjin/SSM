package com.bjsxt.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Users;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersMapper mapper = (UsersMapper) ac.getBean("usersMapper", UsersMapper.class);
		Users users = new Users();
		users.setUname("lisi");
		users.setUpwd("123456");
		Users user = mapper.login(users);
		System.out.println(user);
	}
}
