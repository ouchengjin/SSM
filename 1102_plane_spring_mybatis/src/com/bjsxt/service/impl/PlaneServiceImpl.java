package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.mapper.PlaneMapper;
import com.bjsxt.pojo.Plane;
import com.bjsxt.service.PlaneService;
public class PlaneServiceImpl implements PlaneService {
	private PlaneMapper planeMapper;
	
	public PlaneMapper getPlaneMapper() {
		return planeMapper;
	}

	public void setPlaneMapper(PlaneMapper planeMapper) {
		this.planeMapper = planeMapper;
	}

	@Override
	public List<Plane> selAll(int sid, int eid) {
		return planeMapper.selAll(sid, eid);
	}
}
