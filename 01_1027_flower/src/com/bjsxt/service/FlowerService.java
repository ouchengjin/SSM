package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Flower;

public interface FlowerService {

	List<Flower> queryAll();
	
	boolean addFlower(Flower flower);
}
