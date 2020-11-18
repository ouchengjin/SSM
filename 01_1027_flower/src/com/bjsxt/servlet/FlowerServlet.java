package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.impl.FlowerServiceImpl;

@WebServlet("/flower.sxt")
public class FlowerServlet extends BaseServlet {

	private FlowerService fs = new FlowerServiceImpl();

	/**
	 * 查询所有花卉信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void queryFlower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Flower> list = fs.queryAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	/**
	 * 添加花卉信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addFlower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Flower flower  = new Flower();
		flower.setName(req.getParameter("name"));
		flower.setPrice(Float.parseFloat(req.getParameter("price")));
		flower.setProduction(req.getParameter("production"));
		if(fs.addFlower(flower)) {
			queryFlower(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/addFlower.jsp");
		}
	}
}
