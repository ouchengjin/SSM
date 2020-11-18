package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Users;

public interface UsersMapper {
	
	@Results(value={
			@Result(id=true,property="id",column="id"),
			@Result(property="uname",column="uname"),
			@Result(property="upwd",column="upwd"),
			@Result(property="list",many=@Many(select="com.bjsxt.mapper.MenuMapper.selMenu"),column="{uid=id,pid=pid}")
			
	})
	@Select("select u.*,0 pid from users u where uname=#{uname} and upwd=#{upwd}")
	Users login(Users users);
}
