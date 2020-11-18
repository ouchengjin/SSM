package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bjsxt.pojo.Res;

public interface ResMapper {
	@Select("select * from t_resource")
	List<Res> selRes();
	@Update("update t_resource set dcount=dcount+1 where id = #{0}")
	int updCout(int id);
}
