package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Plane;

public interface PlaneMapper {
	
	List<Plane> selAll(@Param("sid") int sid,@Param("eid")int eid);
}
