package com.bjsxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Menu;

public interface MenuMapper {
	
	List<Menu> selMenu(@Param("rid") int rid,@Param("pid")int pid);
}
