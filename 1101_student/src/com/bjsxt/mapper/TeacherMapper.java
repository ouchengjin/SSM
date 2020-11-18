package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Teacher;

public interface TeacherMapper {
	/**
	 * 根据老师编号查询老师信息
	 * @Title: selById
	 * @param id
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-07-05 21:16:51
	 */
	Teacher selById(@Param("id") int id);
}
