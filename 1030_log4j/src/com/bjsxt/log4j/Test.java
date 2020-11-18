package com.bjsxt.log4j;

import org.apache.log4j.Logger;

public class Test {

	public static  void testLog4j(){
		//将当前类的Class对象作为参数
		Logger logger = Logger.getLogger(Test.class);
		logger.debug("我是debug");
		logger.info("我是info");
		logger.warn("我是warn");
		logger.error("我是error");
		logger.fatal("我是fatal");
		
	}
	public static void main(String[] args) {
		testLog4j();
	}

}
