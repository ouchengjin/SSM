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
	 * @Title: queryFlower
	 * @param req
	 * @param resp
	 * @author Alan Ouyang
	 * @throws IOException 
	 * @throws ServletException 
	 * @date 2020-06-22 18:43:23
	 */
	public void queryFlower(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		List<Flower> list = fs.queryAll();
		//存到作用域中
		req.setAttribute("list", list);
		//页面跳转     dispatcher：调度员
		req.getRequestDispatcher("/index.jsp").forward(req, resp);;
	}
	/**
	 * 添加花卉信息
	 * @Title: addFlower
	 * @param req
	 * @param resp
	 * @author Alan Ouyang
	 * @throws IOException 
	 * @throws ServletException 
	 * @date 2020-06-22 19:00:22
	 */
	public void addFlower(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		Flower flower = new Flower();
		flower.setName(req.getParameter("name"));
		flower.setPrice(Float.parseFloat(req.getParameter("price")));
		flower.setProduction(req.getParameter("production"));
		if(fs.addFlower(flower)){
			queryFlower(req, resp);
			
		}else{
			//为了避免请求转发过去后刷新页面表单重复提交，重定向重新进入这个页面
			//切记不加“/”，"/"是服务器的根路径，加了"/"还要加项目名字 
			resp.sendRedirect("addFlower.jsp");
//			resp.sendRedirect(req.getContextPath()+"/addFlower.jsp");
			
		}
	}
	
}
