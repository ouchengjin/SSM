package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
/**
 * addFlower方法有误
 * @ClassName: FlowerServiceImpl
 * @author Alan Ouyang
 * @date 2020-06-25 14:45:19
 */
public class FlowerServiceImpl implements FlowerService{

	@Override
	public List<Flower> queryAll() throws IOException {
		//加载mybatis的配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//采用工厂模式即构建者模式，得到SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//通过工厂生成SqlSession对象
		SqlSession session = factory.openSession();
		//调用方法查询所有花卉信息,参数表示要调用mapper中的哪个（方法）
		System.out.println("selectList");
		List<Flower> selectList = session.selectList("com.bjsxt.mapper.FlowerMapper.queryAll");
		return selectList;
	}

	@Override
	public boolean addFlower(Flower flower) throws IOException {
		//加载mybatis的配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//采用工厂模式即构建者模式，得到SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//通过工厂生成SqlSession对象
		SqlSession session = factory.openSession();
		//调用方法查询所有花卉信息,参数表示要调用mapper中的哪个（方法）
		
		int num = session.insert("com.bjsxt.mapper.FlowerMapper.addFlower", flower);
		if(num>0){
			session.commit();
			return true;
		}else{
			
			return false;
		}
	}

}
