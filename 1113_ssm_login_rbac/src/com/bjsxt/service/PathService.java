package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Path;
import com.bjsxt.pojo.Users;

public interface PathService {
	
	List<Path> selPath(Users users);
}
