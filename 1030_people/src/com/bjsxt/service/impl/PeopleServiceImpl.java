package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> queryAll() throws IOException {
		//加载mybatis的配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//采用工厂模式即构建者模式，得到SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//通过工厂生成SqlSession对象
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.bjsxt.mapper.PeopleMapper.queryAll");
		
		session.close();
		return list;
	}

}
