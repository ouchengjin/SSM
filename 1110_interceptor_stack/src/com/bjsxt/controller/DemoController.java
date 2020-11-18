package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@RequestMapping("demo01")
	public String demo01(){
		System.out.println("DemoController.demo01()");
		return "index.jsp";
	}
	
	@RequestMapping("demo02")
	public ModelAndView demo02(){
		System.out.println("DemoController.demo02()");
		ModelAndView mav = new ModelAndView("index.jsp");
		mav.addObject("msg","我爱北京天安门");
		int a = 1/0;
		return mav;
	}
}
