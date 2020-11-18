package com.bjsxt.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @ClassName: JDBCUtils
 * @Description: 封装了JDBC查询常用的操作
 * @author Alan Ouyang
 * @date 2020-06-16 22:19:55
 */
public class JDBCUtils {
	
	/**
	 * 给sql设参数
	 * @Title: handleParams
	 * @param ps 预编译sql语句对象
	 * @param params 参数
	 * @author Alan Ouyang
	 * @date 2020-06-19 11:36:44
	 */
	public static void handleParams(PreparedStatement ps,Object[] params){
		if(params!=null){
			for(int i =0;i<params.length;i++){
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
