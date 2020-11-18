package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.Airport;
import com.bjsxt.service.AirportService;
@WebServlet("/airport.sxt")
public class AirportServlet extends HttpServlet {
	private AirportService airportService;
	/**
	 * init在service之前会执行,所以重写,为airportService赋值
	 * @Title: init
	 * @throws ServletException 
	 * @see javax.servlet.GenericServlet#init() 
	 * @author Alan Ouyang
	 * @date 2020-07-14 09:33:51
	 */
	@Override
	public void init() throws ServletException {
		ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
		airportService = as.getBean("airportService", AirportService.class);
		
	}



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Airport> list = airportService.selAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
