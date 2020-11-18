package com.bjsxt.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.mapper.PlaneMapper;
import com.bjsxt.pojo.Plane;
import com.bjsxt.service.PlaneService;
import com.bjsxt.util.MybatisUtil;

public class PlaneServiceImpl implements PlaneService {

	@Override
	public List<Plane> selAll(int sid, int eid) {
		SqlSession session = MybatisUtil.getSqlSession();
		PlaneMapper mapper = session.getMapper(PlaneMapper.class);
		List<Plane> list = mapper.selAll(sid, eid);
		return list;
	}

}
