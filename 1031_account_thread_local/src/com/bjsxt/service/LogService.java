package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import com.bjsxt.pojo.Log;
import com.bjsxt.pojo.Pagination;

public interface LogService {
	
	List<Log> selLog(Pagination<Log> p) throws IOException;
	int selCount() throws IOException;

}
