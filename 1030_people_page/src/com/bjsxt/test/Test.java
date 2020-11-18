package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.People;

public class Test {

	public static void main(String[] args) {
		//加载mybatis的配置文件
		InputStream is =  null ;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//采用工厂模式即构建者模式，得到SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//通过工厂生成SqlSession对象
		SqlSession session = factory.openSession();
//		People people = session.selectOne("com.bjsxt.mapper.PeopleMapper.queryById",2);
//		People people = session.selectOne("com.bjsxt.mapper.PeopleMapper.queryByName","张三");
		
		/*People people2 = new People();
		people2.setId(1);
		people2.setName("张三");;*/
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "2");
		map.put("name", "李四");
		
		People people = session.selectOne("com.bjsxt.mapper.PeopleMapper.queryTest",map);
		System.out.println(people);
		session.close();
	}

}
