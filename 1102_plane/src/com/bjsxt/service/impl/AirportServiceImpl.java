package com.bjsxt.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.mapper.AirportMapper;
import com.bjsxt.pojo.Airport;
import com.bjsxt.service.AirportService;
import com.bjsxt.util.MybatisUtil;

public class AirportServiceImpl implements AirportService{

	@Override
	public List<Airport> selAll() {
		SqlSession session = MybatisUtil.getSqlSession();
		AirportMapper mapper = session.getMapper(AirportMapper.class);
		List<Airport> list = mapper.selAll();
		return list;
	}
	
}
