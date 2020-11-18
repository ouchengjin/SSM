package com.bjsxt.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("demo.sxt")
	public String demo(HttpServletRequest req){
		String test = req.getParameter("test");
		System.out.println("DemoController.demo()"+test);
		return "demo.jsp";
	}
}
