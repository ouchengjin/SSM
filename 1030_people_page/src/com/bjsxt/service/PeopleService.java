package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.People;

public interface PeopleService {
	
	List<People> queryAll(Pagination<People> p) throws IOException;
	
	int queryCount() throws IOException;
}
