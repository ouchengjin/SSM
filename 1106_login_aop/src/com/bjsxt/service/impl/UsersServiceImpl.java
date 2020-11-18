package com.bjsxt.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;
	
	@Value("${testName}")
	private String test;

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}



	@Override
	public Users selUsers(Users users) {
		System.out.println(test);
		return usersMapper.selUsers(users);
	}

}
