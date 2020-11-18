package com.bjsxt.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取当前线程的SqlSession对象
	 * @Title: getSession
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-07-02 22:23:08
	 */
	public static SqlSession getSession(){
		if(tl.get() == null){
			tl.set(factory.openSession());
		}
		return tl.get();
	}
	/**
	 * 关闭当前线程的SqlSession资源
	 * @Title: close
	 * @author Alan Ouyang
	 * @date 2020-07-02 22:23:01
	 */
	public static void close(){
		if(tl.get()!=null){
			tl.get().close();
			tl.remove();
//			tl.set(null);
		}
	}
}
