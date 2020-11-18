package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.pojo.Menu;
import com.bjsxt.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;
	@Override
	public List<Menu> selMenu(int rid, int pid) {
		List<Menu> list = menuMapper.selMenu(rid, pid);
		System.out.println(list);
		return list;
	}

}
