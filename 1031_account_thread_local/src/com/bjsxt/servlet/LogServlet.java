package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Log;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.LogService;
import com.bjsxt.service.impl.LogServiceImpl;
@WebServlet("/log.sxt")
public class LogServlet extends HttpServlet {
	private LogService ls = new LogServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String size = req.getParameter("size");
		int totalCount = ls.selCount();
		Pagination<Log> p = new Pagination<Log>(page, size, totalCount);
		List<Log> list = ls.selLog(p);
		p.setList(list);
		
		req.setAttribute("p", p);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
