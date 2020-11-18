package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.MenuService;
import com.bjsxt.service.PathService;
import com.bjsxt.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper usersMapper;	
	@Autowired
	private MenuService menuServiceImpl;
	@Autowired
	private PathService pathServiceImpl;
	@Override
	public Users login(Users users) {
		Users user = usersMapper.login(users);
		if (user!=null) {
			//查询该用户所有的菜单信息
			Integer rid = user.getRid();
			List<Menu> list = menuServiceImpl.selMenu(rid, 0);
			user.setList(list);
			//查询该用户可以访问的路径集合
			user.setPlist(pathServiceImpl.selPath(user));
		}
		return user;
	}

}
