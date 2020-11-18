package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.AccountMapper;
import com.bjsxt.pojo.Account;

public class TestForeach {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		
	
		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(4);
		Collections.addAll(list, 1,2,3);
		List<Account> list2 = mapper.selByIn(list);
		
		for (Account account2 : list2) {
			System.out.println(account2);
		}
		
			
		
		session.close();
	}

}
