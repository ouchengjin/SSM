package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Flower;

public interface FlowerDao {

	/**
	 * 查询所有
	 * @Title: queryAll
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-22 17:52:27
	 */
	List<Flower> queryAll();
	/**
	 * 添加花卉信息
	 * @Title: addFlower
	 * @param flower
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-22 17:52:38
	 */
	boolean addFlower(Flower flower);
	
}
