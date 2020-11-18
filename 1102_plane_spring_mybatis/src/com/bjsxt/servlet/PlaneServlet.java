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

import com.bjsxt.pojo.Plane;
import com.bjsxt.service.AirportService;
import com.bjsxt.service.PlaneService;
import com.bjsxt.service.impl.PlaneServiceImpl;
@WebServlet("/plane.sxt")
public class PlaneServlet extends HttpServlet {
	private PlaneService planeService;
	
	@Override
	public void init() throws ServletException {
		ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
		planeService = as.getBean("planeService", PlaneServiceImpl.class);
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		int eid = Integer.parseInt(req.getParameter("eid"));
		
		List<Plane> plist = planeService.selAll(sid, eid);
		req.setAttribute("plist", plist);
		req.setAttribute("sid", sid);
		req.setAttribute("eid", eid);
		req.getRequestDispatcher("airport.sxt").forward(req, resp);
		
	}
}
