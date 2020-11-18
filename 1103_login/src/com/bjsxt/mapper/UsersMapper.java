package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Select;

public interface UsersMapper {
	@Select("select * from users where uname = #{0} and upwd=#{1}")
	Users selUser(String uname,String upwd);
}
