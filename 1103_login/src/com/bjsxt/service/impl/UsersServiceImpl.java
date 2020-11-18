package com.bjsxt.service.impl;

import com.bjsxt.mapper.Users;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Users selUser(String uname, String upwd) {
		return usersMapper.selUser(uname, upwd);
	}


	

}
