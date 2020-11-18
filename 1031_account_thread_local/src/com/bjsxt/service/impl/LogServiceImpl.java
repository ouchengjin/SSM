package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.Log;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.LogService;
import com.bjsxt.util.MybatisUtil;

public class LogServiceImpl implements LogService {

	@Override
	public List<Log> selLog(Pagination<Log> p) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		return session.selectList("com.bjsxt.mapper.LogMapper.selLog", p);
	}

	@Override
	public int selCount() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("com.bjsxt.mapper.LogMapper.selCount");
	}

}
