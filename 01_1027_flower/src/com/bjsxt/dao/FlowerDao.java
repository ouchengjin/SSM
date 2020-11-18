package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Flower;

public interface FlowerDao {

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<Flower> queryAll();

	/**
	 * 添加花卉信息
	 * 
	 * @param flower
	 * @return
	 */
	boolean addFlower(Flower flower);
}
