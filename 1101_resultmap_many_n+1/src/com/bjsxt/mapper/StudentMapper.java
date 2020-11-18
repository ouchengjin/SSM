package com.bjsxt.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Student;

public interface StudentMapper {
	List<Student> selById(@Param("id") int id);
}
