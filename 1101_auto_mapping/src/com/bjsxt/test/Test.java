package com.bjsxt.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.mapper.StudentMapper;
import com.bjsxt.pojo.Student;
import com.bjsxt.util.MybatisUtil;

public class Test {

	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSqlSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> list = mapper.selAll();
		for (Student student : list) {
			System.out.println(student);
			
		}
		MybatisUtil.close();
		
	}

}
