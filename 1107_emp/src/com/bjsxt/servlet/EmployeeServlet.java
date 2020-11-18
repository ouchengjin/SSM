package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/emp.sxt")
public class EmployeeServlet extends HttpServlet {
	private EmployeeService employeeService;
	
	@Override
	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		employeeService = wac.getBean("employeeServiceImpl",EmployeeServiceImpl.class);
	}
	@Override
	protected  void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");此行是以前没使用json用的
		resp.setContentType("application/json;charset=utf-8");
		String page = req.getParameter("page");
		String size = req.getParameter("size");
		int totalCount = employeeService.selCount();
		Pagination<Employee> p = new Pagination<Employee>(page, size, totalCount);
		p.setList(employeeService.selEmp(p));
		//将对象转化为json格式
		//对象:{"key":"value",...}
		//数组:{value1,values,...}
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(p);
		resp.getWriter().print(writeValueAsString);
		
	}
}
