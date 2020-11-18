package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.util.MybatisUtil;
@WebFilter("/*")
public class OpenSessionInView implements Filter {

	@Override
	public void destroy() {
		System.out.println("destory");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			chain.doFilter(req, resp);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtil.close(); 
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");

	}

}
