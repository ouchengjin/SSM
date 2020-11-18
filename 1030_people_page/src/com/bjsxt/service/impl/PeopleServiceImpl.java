package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> queryAll(Pagination<People> p) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.bjsxt.mapper.PeopleMapper.queryAll",p);
		session.close();
		
		return list;
	}

	@Override
	public int queryCount() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		int totalCount = session.selectOne("com.bjsxt.mapper.PeopleMapper.queryCount");
		session.close();
		
		return totalCount;
	}

	
}
