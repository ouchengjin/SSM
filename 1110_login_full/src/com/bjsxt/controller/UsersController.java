package com.bjsxt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersServiceImpl;
	@RequestMapping("login")
	public String login(Users users,HttpServletRequest req){
		Users u = usersServiceImpl.selUsers(users.getUname(), users.getUpwd());
		//将用户信息存储到session作用域
		req.getSession().setAttribute("u", u);
		if (u!=null) {
			//因为有了视图解析器,才写的这么简单
			return "redirect:index";
		} else {
			req.getSession().setAttribute("msg", "账号或密码错误");
			return "redirect:login.jsp";
		}
	}
	@RequestMapping("{page}")
	public String page(@PathVariable String page){
		return page;
	}
	
	/*@RequestMapping("index")
	public String index(){
		//因为有了视图解析器,才写的这么简单
		return "index";
	}
	@RequestMapping("demo")
	public String demo(){
		return "demo";
	}
	@RequestMapping("test")
	public String test(){
		return "test";
	}*/
}
