package com.bjsxt.mapper;

import java.util.List;

import com.bjsxt.pojo.Menu;

public interface MenuMapper {
	
	List<Menu> selMenu(int pid);
}
