package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Student;

public interface StudentService {
	List<Student> selAll(String sname,String tname,Pagination<Student> p);
	
	int selCount(String sname,String tname);
}
