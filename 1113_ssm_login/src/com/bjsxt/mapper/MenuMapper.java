package com.bjsxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Menu;

public interface MenuMapper {
	
	@Results(value={
			@Result(id=true,property="id",column="id"),
			@Result(property="menu",column="menu"),
			@Result(property="pid",column="pid"),
			@Result(property="list",many=@Many(select="selMenu"),column="{uid=uid,pid=id}")
			
	})
	@Select("select m.*, #{uid} uid from menu m where id in(select mid from user_menu where uid = #{uid}) and  pid =#{pid}")
	List<Menu> selMenu(Map<String, Object> map);
}
