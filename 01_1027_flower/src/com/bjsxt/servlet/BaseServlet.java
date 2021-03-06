package com.bjsxt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		try {
			Method m = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			m.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
