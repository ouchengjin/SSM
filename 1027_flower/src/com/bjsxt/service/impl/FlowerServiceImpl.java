package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.FlowerDao;
import com.bjsxt.dao.impl.FlowerDaoImpl;
import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	private FlowerDao dao = new FlowerDaoImpl(); 
	@Override
	public List<Flower> queryAll() {
		return dao.queryAll();
	}

	@Override
	public boolean addFlower(Flower flower) {
		return dao.addFlower(flower);
	}

}
