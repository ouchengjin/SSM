package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Path;
import com.bjsxt.pojo.Users;

public interface PathMapper {
	
	@Select("SELECT * FROM path where id in (select pid from role_path where rid = #{rid})")
	List<Path> selPath(Users users);
}	
