package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class DemoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DemoServlet.service");
		String demo = req.getParameter("demo");
		
		if("demo1".equals(demo)){
			demo1(req,resp);
		} else if ("demo2".equals(demo)){
			demo2(req,resp);
		}
		
	}

	private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("demo2");
	}

	private void demo1(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("demo1");
		
	}
}
