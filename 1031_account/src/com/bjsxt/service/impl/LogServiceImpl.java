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

public class LogServiceImpl implements LogService {


	@Override
	public List<Log> selLog(Pagination<Log> p) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<Log> list = session.selectList("com.bjsxt.mapper.LogMapper.selLog", p);
		System.out.println(list.get(0).getBalance());
		session.close();
		return list;
	}

	@Override
	public int selCount() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		int count = session.selectOne("com.bjsxt.mapper.LogMapper.selCount");
		
		session.close();
		return count;
	}

}
