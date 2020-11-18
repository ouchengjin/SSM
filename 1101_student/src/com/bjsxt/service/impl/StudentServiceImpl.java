package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.mapper.StudentMapper;
import com.bjsxt.mapper.TeacherMapper;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.service.StudentService;
import com.bjsxt.util.MybatisUtil;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> selAll(String sname, String tname, Pagination<Student> p) {
		SqlSession session = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		//此时的list中没有teacher对象的值
		List<Student> selAllList = studentMapper.selAll(sname, tname, p);
		//得到TeacherMapper对象
		TeacherMapper TeacherMapper = session.getMapper(TeacherMapper.class);
		//一次为每个Student对象设置teacher属性
		for (Student student : selAllList) {
			Teacher teacher = TeacherMapper.selById(student.getTid());
			student.setTeacher(teacher);
		}
		return selAllList;
	}

	@Override
	public int selCount(String sname, String tname) {
		SqlSession session = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		int selCount = studentMapper.selCount(sname, tname);
		
		return selCount;
	}

}
