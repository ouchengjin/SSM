package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper usermapper;
	@Override
	public int insUser(User user) {
		return usermapper.insUser(user);
	}

}
