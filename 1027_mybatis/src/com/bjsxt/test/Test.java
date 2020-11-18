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
		//调用方法查询所有花卉信息,参数表示要调用mapper中的哪个（方法）
		System.out.println("selectList");
		List<Flower> selectList = session.selectList("com.bjsxt.mapper.FlowerMapper.queryAll");
		for (Flower flower : selectList) {
			System.out.println(flower);
		}
		
		System.out.println("selectOne");
		Flower oneFlower = session.selectOne("com.bjsxt.mapper.FlowerMapper.queryById");
		System.out.println(oneFlower);
		
		System.out.println("selectMap");
		Map<String, Flower> selectMap = session.selectMap("com.bjsxt.mapper.FlowerMapper.queryAll","name");
		for (String key : selectMap.keySet()) {
			System.out.println(key+"---"+selectMap.get(key));
		}
		//关闭资源
		if(session!=null){
			session.close();
		}
		 
		
	}

}
