package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService ss = new StudentServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sname = req.getParameter("sname");
		String tname = req.getParameter("tname");
		String page = req.getParameter("page");
		String size = req.getParameter("size");
		int totalCount = ss.selCount(sname, tname);
		//如果是get方式，解决中文乱码问题
//		if(req.getMethod().toLowerCase().equals("get")){
//			if(sname!=null&&sname!=""){
//				System.out.println(req.getCharacterEncoding());
//				sname=new String(sname.getBytes("iso-8859-1"), "utf-8");
//			}
//			if(tname!=null&&tname!=""){
//				System.out.println(req.getCharacterEncoding());
//				tname=new String(tname.getBytes("iso-8859-1"), "utf-8");
//			}
//		}
		Pagination<Student> p = new Pagination<Student>(page, size, totalCount);
		List<Student> list = ss.selAll(sname, tname, p);
		p.setList(list);
		p.setSname(sname);
		p.setTname(tname);
		req.setAttribute("p", p);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
		
	}


}
