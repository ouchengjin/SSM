package com.bjsxt.mapper;


import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Teacher;

public interface TeacherMapper {
	@Select("select * from teacher where id =#{0}")
	Teacher selById(int id);
}
