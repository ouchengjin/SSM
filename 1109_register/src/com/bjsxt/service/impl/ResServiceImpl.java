package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.ResMapper;
import com.bjsxt.pojo.Res;
import com.bjsxt.service.ResService;
@Service
public class ResServiceImpl implements ResService {
	@Resource
	private ResMapper resMapper;
	@Override
	public List<Res> selRes() {
		return resMapper.selRes();
	}
	@Override
	public int updCount(int id) {
		return resMapper.updCout(id);
	}

}
