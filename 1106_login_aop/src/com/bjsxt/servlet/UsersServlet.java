package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import com.bjsxt.service.impl.UsersServiceImpl;
@WebServlet("/login.sxt")
public class UsersServlet extends HttpServlet {
	private UsersService usersService;
	@Override
	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		usersService = wac.getBean("usersService", UsersServiceImpl.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = new Users();
		users.setUname(req.getParameter("uname"));
		users.setUpwd(req.getParameter("upwd"));
		Users result = usersService.selUsers(users);
		if(result != null){
			resp.sendRedirect("index.jsp");
		}else {
			req.setAttribute("msg", "登陆失败");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
