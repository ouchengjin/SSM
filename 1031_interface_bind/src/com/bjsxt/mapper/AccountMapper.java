package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Account;

public interface AccountMapper {
	List<Account> selAll();
	/**
	 * 在加上@Param注解之后，mybatis将参数封装成了一个map集合
	 * @Title: selByIdName
	 * @param id
	 * @param name
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-07-01 16:15:30
	 */
	Account selByIdName(@Param(value = "id") int id,@Param(value = "name") String name);
//	Account selByIdName(int id,String name);
	
	
}
