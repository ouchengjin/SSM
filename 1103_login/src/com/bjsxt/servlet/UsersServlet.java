package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.mapper.Users;
import com.bjsxt.service.UsersService;
import com.bjsxt.service.impl.UsersServiceImpl;
@WebServlet("/login.sxt")
public class UsersServlet extends HttpServlet {
	private UsersService usersService;
	
	@Override
	public void init() throws ServletException {
//		ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		usersService = wac.getBean("usersService",UsersServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upwd = req.getParameter("upwd");
		String code = req.getParameter("code");
		Users user = usersService.selUser(uname, upwd);
		String msg = "";
		if(code!=null && code.equalsIgnoreCase((String) req.getSession().getAttribute("vcode"))){
			if(user!= null){
				msg = "登录成功";
			}else{
				msg = "登录失败,账号或密码错误";
			}
		}else{
			msg = "验证码错误";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
