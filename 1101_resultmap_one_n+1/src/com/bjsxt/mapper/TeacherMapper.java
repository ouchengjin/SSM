package com.bjsxt.mapper;


import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Teacher;

public interface TeacherMapper {
	
	Teacher selById(@Param("id") int id);
}
