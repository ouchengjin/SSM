package com.bjsxt.controller;

import javax.servlet.http.HttpSession;

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
	public String login(Users users,HttpSession session){
		Users user = usersServiceImpl.login(users);
		if (user!=null) {
			session.setAttribute("user", user);
			return "redirect:main";
		} 
		return "redirect:login.jsp";
	}
	
	@RequestMapping("{page}")
	public String page(@PathVariable String page){
		return page;
	}
}
