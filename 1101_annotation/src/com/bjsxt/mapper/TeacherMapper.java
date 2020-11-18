package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bjsxt.pojo.Teacher;

public interface TeacherMapper {
	@Select("select * from student")
	List<Teacher> selAll();
	
	@Insert("insert into teacher values (default,#{name})")
	int add(Teacher teacher);
	@Update("update teacher set name = #{name} where id = #{id}")
	int upd(Teacher teacher);
	@Delete("delete from teacher where id = #{0}")
	int del(int id);
}
