package com.bjsxt.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.bjsxt.pojo.Users;

public class UsersBefore implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		Logger logger = Logger.getLogger(UsersBefore.class);
		Users u = (Users) arg1[0];
		logger.error(u.getUname()+"在"+new Date().toLocaleString()+"进行登录");
	}

}
