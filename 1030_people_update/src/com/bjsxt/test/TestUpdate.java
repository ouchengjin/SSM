package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.People;

public class TestUpdate {

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
//		//开启自动提交
//		SqlSession session = factory.openSession(true);
		People people = new People();
		people.setId(1);
		people.setName("张无忌");
		people.setAge(18);
		//此处写update和delete和insert都无所谓（因为底层使用同一个方法），第一个参数决定了一切。
		int r = session.update("com.bjsxt.mapper.PeopleMapper.updatePeople",people);
		if(r>0){
			//提交事务
			session.commit();
			System.out.println("successful");
		}else{
			//事务回滚
			session.rollback();
			System.out.println("failed");
		}
		session.close();
	}

}
