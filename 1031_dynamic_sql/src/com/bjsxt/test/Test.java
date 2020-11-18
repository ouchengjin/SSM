package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = sc.nextLine();
		System.out.println("请输入密码：");
		String pwd = sc.nextLine();
		List<Account> list = mapper.sel(name, pwd);
		for (Account account : list) {
			System.out.println(account);
		}
		sc.close();
		session.close();
		

	}

}
