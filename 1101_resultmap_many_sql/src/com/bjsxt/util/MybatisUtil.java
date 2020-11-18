package com.bjsxt.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory = null ;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession(){
		if(tl.get()==null){
			tl.set(factory.openSession());
		}
		return tl.get();
	}
	
	public static void close(){
		if(tl.get()!=null){
			tl.get().close();
			tl.remove();
		}
	}
	
}
