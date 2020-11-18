package com.bjsxt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Menu;
import com.bjsxt.service.MenuService;

@Controller
public class MenuController {
	@Resource
	private MenuService menuserviceImpl;
	@RequestMapping("menu.sxt")
	@ResponseBody
	public List<Menu> selMenu(){
		List<Menu> list = menuserviceImpl.selMenu(0);
		return list;
	}
}