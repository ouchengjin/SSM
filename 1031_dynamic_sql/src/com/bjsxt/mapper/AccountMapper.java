package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Account;

public interface AccountMapper {
	//有参数就查，没参数就查所有
	List<Account> sel(@Param(value = "name") String name,@Param(value = "pwd") String pwd);
	
	int upd(Account account);
	
	List<Account> selByIn(@Param(value = "list") List<Integer> list);
}
