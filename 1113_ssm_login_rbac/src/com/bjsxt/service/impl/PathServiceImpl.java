package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.PathMapper;
import com.bjsxt.pojo.Path;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.PathService;
@Service
public class PathServiceImpl implements PathService {
	@Resource
	private PathMapper pathMapper;
	@Override
	public List<Path> selPath(Users users) {
		return pathMapper.selPath(users);
	}

}
