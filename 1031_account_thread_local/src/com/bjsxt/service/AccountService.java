package com.bjsxt.service;

import java.io.IOException;

import com.bjsxt.pojo.Account;

public interface AccountService {
	
	/**
	 * 账号密码不匹配
	 */
	public static final int ID_PWD_NOT_MATCHED = 1;
	
	/**
	 * 余额不足
	 */
	public static final int BALANCE_NOT_ENOUGH = 2;
	
	/**
	 * 账号姓名不匹配
	 */
	public static final int ID_NAME_NOT_MATCHED = 3;
	
	/**
	 * 转账失败
	 */
	public static final int FAILED = 4;
	/**
	 * 转账成功
	 */
	public static final int SUCCESS = 5;
	
	/**
	 * 转账操作
	 * @Title: transfer
	 * @param accOut 转出账户
	 * @param accIn 转入账户
	 * @return
	 * @author Alan Ouyang
	 * @throws IOException 
	 * @date 2020-06-29 15:18:36
	 */
	int transfer(Account accOut,Account accIn) throws IOException;
}
