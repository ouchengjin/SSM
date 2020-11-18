package com.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.pojo.Menu;
import com.bjsxt.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> selMenu(int pid) {
		return menuMapper.selMenu(pid);
	}

}
