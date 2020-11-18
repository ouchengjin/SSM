package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Pagination;

public interface EmployeeService {
	
	List<Employee> selEmp(Pagination<Employee> p);
	
	int selCount();
}
