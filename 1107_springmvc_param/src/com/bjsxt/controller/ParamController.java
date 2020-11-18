package com.bjsxt.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.People;

@Controller
public class ParamController {
	@RequestMapping("param1.sxt")
	public String demo1(HttpServletRequest req){
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println(name+":"+age);
		System.out.println("param1.sxt");
		return "demo.jsp";
	}
	@RequestMapping("param2.sxt")
	public String demo2(String name,int age){
		System.out.println(name+":"+age);
		System.out.println("param2.sxt");
		return "param1.sxt";
	}
	@RequestMapping("param3.sxt")
	public String demo3(@RequestParam(value="name",defaultValue="demo")String name1,@RequestParam(value="age",defaultValue="20",required=true)int age1){
		System.out.println(name1+":"+age1);
		return "demo.jsp";
	}
	@RequestMapping("param4.sxt")
	public String demo4(People p){
		System.out.println(p);
		return "demo.jsp";
	}
	@RequestMapping("param.sxt/{name}/{age}")
	public String demo5(@PathVariable("name")String name,@PathVariable("age")int age1){
		System.out.println(name+":"+age1);
		//默认模式是请求转发,加上斜杠会在项目根路径找demo.jsp,如果不加斜杠,会在{name}下找,找不到
		return "/demo.jsp";
	}
	@RequestMapping("param6.sxt")
	public String demo6(HttpServletRequest req){
		req.setAttribute("uname", "欧成金");
		return "demo.jsp";
	}
	@RequestMapping("param7.sxt")
	public String demo7(Map<String, Object> map){
		map.put("uname", "欧成金国王");
		return "demo.jsp";
	}
	@RequestMapping("param8.sxt")
	public String demo8(Model model){
		model.addAttribute("uname", "联合国国王");
		//redirect表示重定向
		//return "redirect:demo.jsp";
		//forward表示请求转发,默认
		return "forward:demo.jsp";
	}
	@RequestMapping("demo")
	@ResponseBody//@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	//数据，需要注意的呢，在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
	public List<People> demo(){
		ArrayList<People> list = new ArrayList<People>();
		People p1 = new People();
		People p2 = new People();
		People p3 = new People();
		p1.setName("demo1");
		p2.setName("demo2");
		p3.setName("demo3");
		p1.setAge(18);
		p2.setAge(19);
		p3.setAge(20);
		Collections.addAll(list, p1,p2,p3);
		return list;
	}
}
