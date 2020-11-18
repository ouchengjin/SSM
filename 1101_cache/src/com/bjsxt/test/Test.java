package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.Flower;

/**
 * 该测试类不用会写，以后不用
 * @ClassName: Test
 * @author Alan Ouyang
 * @date 2020-06-24 22:03:07
 */
public class Test {

	public static void main(String[] args) throws IOException {
		//加载mybatis的配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//采用工厂模式即构建者模式，得到SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//通过工厂生成SqlSession对象
		SqlSession session = factory.openSession();
		
		List<Object> list = session.selectList("com.bjsxt.mapper.FlowerMapper.queryAll");
		System.out.println(list);
		
		//关闭资源
		if(session!=null){
			session.close();
		}
		SqlSession session2 = factory.openSession();
		List<Object> list2 = session2.selectList("com.bjsxt.mapper.FlowerMapper.queryAll");
		System.out.println(list2);
		session2.close();
	}

}
