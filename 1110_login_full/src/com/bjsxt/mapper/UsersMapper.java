package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Users;

public interface UsersMapper {
	@Select("select * from users where uname= #{0} and upwd=#{1}")
	Users selUsers(String uname,String upwd);
}
