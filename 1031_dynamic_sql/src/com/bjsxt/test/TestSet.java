package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.AccountMapper;
import com.bjsxt.pojo.Account;

public class TestSet {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		
		Account account = new Account();
		account.setId(1);
		account.setName("张无忌");;
		account.setPwd("123456");
		int upd = mapper.upd(account);
		if(upd>0){
			session.commit();
		}else{
			session.rollback();
		}
		
		session.close();
	}

}
