package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import com.bjsxt.pojo.Flower;

public interface FlowerService {

	List<Flower> queryAll() throws IOException;
	
	boolean addFlower(Flower flower) throws IOException;
	
}
