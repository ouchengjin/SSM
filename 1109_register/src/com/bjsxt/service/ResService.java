package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Res;

public interface ResService {
	
	List<Res> selRes();
	
	int updCount(int id);
}
