package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Pagination;

public interface EmployeeMapper {
	@Select("select e.*,d.deptno `department.deptno`, d.dname `department.dname` from employee e left join department d on e.deptno = d.deptno limit #{start},#{size}")
	List<Employee> selEmp(Pagination<Employee> p);
	@Select("select count(*) from employee e left join department d on e.deptno = d.deptno")
	int selCount();
}
