package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import com.bjsxt.pojo.People;

public interface PeopleService {
	List<People> queryAll() throws IOException;
}
