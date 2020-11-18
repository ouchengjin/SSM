package com.bjsxt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DemoController {
	@RequestMapping("demo1")
	@ResponseBody
	public void demo1(HttpServletResponse resp) throws IOException{
		System.out.println("DemoController.demo1()");
		resp.getWriter().print("hehe");
	}
	
	@RequestMapping("demo2")
	public String demo1() {
		System.out.println("DemoController.demo2()");
		View view = null;
		return "forward:index.jsp";
	}
	@RequestMapping("demo3")
	public View demo3(){
		System.out.println("DemoController.demo3()");
		//请求转发,使用InternalResourceView对象,加斜杠的话代表项目根路径
		View view = new InternalResourceView("/demo3.jsp");
		//重定向,加斜杠的话代表服务器根路径
		//View view = new RedirectView("demo3.jsp");
		return view;
	}
	@RequestMapping("demo4")
	public ModelAndView demo4(){
		System.out.println("DemoController.demo4()");
		ModelAndView mav = new ModelAndView("demo4.jsp");
		mav.addObject("demo4", "DEMO4");
		return mav;
	}
	@RequestMapping("demo5")
	public String demo5(){
		System.out.println("DemoController.demo5()");
		return "demo5";
	}
	@RequestMapping("demo6")
	public String demo6(){
		System.out.println("DemoController.demo6()");
		//如果返回的字符串前人为的添加了forward:或redirect:, 那么就不会使用自定义视图解析器了. 一般在一个控制器方法调用另一个控制器方法时使用
		return "forward:demo5";
	}
}
