package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Insert;

import com.bjsxt.pojo.User;

public interface UserMapper {
	
	@Insert("insert into t_user values(default,#{uname},#{upwd},#{photo})")
	int insUser(User user);
}
