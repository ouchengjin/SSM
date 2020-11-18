package com.bjsxt.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.mapper.TeacherMapper;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.util.MybatisUtil;

public class Test {

	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSqlSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		List<Teacher> list = mapper.selAll();
		for (Teacher teacher : list) {
			System.out.println(teacher);
			
		}
		MybatisUtil.close();
		
	}

}
