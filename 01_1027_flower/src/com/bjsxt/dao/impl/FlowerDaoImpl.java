package com.bjsxt.dao.impl;

import java.util.List;

import com.bjsxt.dao.FlowerDao;
import com.bjsxt.pojo.Flower;

public class FlowerDaoImpl extends BaseDao implements FlowerDao {

	@Override
	public List<Flower> queryAll() {
		String sql = "select * from flower";
		return query(Flower.class, sql);
	}

	@Override
	public boolean addFlower(Flower flower) {
		String sql = "insert into flower values (default, ?, ?, ?)";
		return update(sql, flower.getName(), flower.getPrice(), flower.getProduction());
	}

}
