package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.EmployeeMapper;
import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;
	@Override
	public List<Employee> selEmp(Pagination<Employee> p) {
		return employeeMapper.selEmp(p);
	}

	@Override
	public int selCount() {
		return employeeMapper.selCount();
	}

}
