package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("demo.sxt")
	public String demo(String name){
		System.out.println(name);
		return "index";
	}
}
