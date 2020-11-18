package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Student;

public interface StudentMapper {
	/**
	 * 有了这些注解后不需要mapper下的xml文件了，文件改名后留作参考
	 * @Title: selAll
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-07-07 22:27:52
	 */
	@Results(value={
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="tid",property="tid"),
		@Result(property="teacher",one=@One(select="com.bjsxt.mapper.TeacherMapper.selById"),column="tid")
	})
	@Select("select * from student")
	List<Student> selAll();
}
