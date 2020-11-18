package com.bjsxt.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.bjsxt.pojo.Users;

public class UsersAfter implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Logger logger = Logger.getLogger(UsersAfter.class);
		String uname =  ((Users) arg2[0]).getUname();
		if(arg0 != null ){
			logger.error(uname+"登录成功");
		}else{
			logger.error(uname+"登录失败");
			
		}
	}

}
