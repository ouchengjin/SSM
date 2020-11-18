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
//过滤所有
@WebFilter("/*")
public class OpenSessionInView implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("OpenSessionInView.init(初始化)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("OpenSessionInView.doFilter(执行)");
		SqlSession session = null;
		try {
			//创建SqlSession对象
			session = MybatisUtil.getSession();
			//该干嘛干嘛
			chain.doFilter(req, resp);
			//提交事务
			session.commit();
		} catch (Exception e) {
			// 事务回滚
			System.out.println(session.toString());
			session.rollback();
			e.printStackTrace();
		}finally{
			//关闭资源
			MybatisUtil.close();
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("OpenSessionInView.destroy(销毁)");

	}



}
