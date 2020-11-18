package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;
@WebServlet("/query.sxt")
public class PeopleServlet extends HttpServlet{
	
	private PeopleService ps = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		String page = req.getParameter("page");
		System.out.println(page);
		String size = req.getParameter("size");
		int totalCount = ps.queryCount();
		Pagination<People> p = new Pagination<>(page, size, totalCount);
		List<People> list = ps.queryAll(p);
		p.setList(list);
		
		req.setAttribute("p", p); 
		req.getRequestDispatcher("/index.jsp").forward(req, rep);
	}
	
	
}
