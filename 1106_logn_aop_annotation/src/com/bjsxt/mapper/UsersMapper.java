package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Users;

public interface UsersMapper {
	@Select("select * from users where uname = #{uname} and upwd = #{upwd}")
	Users selUsers(Users users);
}
