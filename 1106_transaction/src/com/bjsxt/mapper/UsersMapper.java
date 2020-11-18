package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Insert;

import com.bjsxt.pojo.Users;

public interface UsersMapper {
	@Insert("insert into users values ( default,#{uname},#{upwd})")
	int insUsers(Users users);
}
