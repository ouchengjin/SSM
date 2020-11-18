package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.AccountMapper;
import com.bjsxt.pojo.Account;

public class Test {


	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		/*List<Account> list = mapper.selAll();
		for (Account account : list) {
			System.out.println(account);
		}*/
		Account a= mapper.selByIdName(1, "张无忌");
		System.out.println(a);
		session.close();
		

	}

}
