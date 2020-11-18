package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Student;

public interface StudentMapper {
	/**
	 * 查询所有学生信息，支持模糊查询和分页
	 * @Title: selAll
	 * @param sname
	 * @param tname
	 * @param p
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-07-04 23:13:08
	 */
	List<Student> selAll(@Param("sname") String sname,@Param("tname") String tname,@Param("p") Pagination<Student> p);
	
	/**
	 * 查询满足条件的记录数
	 * @Title: selCount
	 * @param sname
	 * @param tname
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-07-04 23:14:36
	 */
	int selCount(@Param("sname") String sname,@Param("tname") String tname);
}
