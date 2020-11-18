package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Airport;
import com.bjsxt.service.AirportService;
import com.bjsxt.service.impl.AirportServiceImpl;
@WebServlet("/airport.sxt")
public class AirportServlet extends HttpServlet {
	private AirportService as = new AirportServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Airport> list = as.selAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
