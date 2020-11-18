package com.bjsxt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;
	
	@Value("${testName}")
	private String test;

	@Override
	public Users selUsers(Users users) {
		System.out.println(test);
		return usersMapper.selUsers(users);
	}

}
