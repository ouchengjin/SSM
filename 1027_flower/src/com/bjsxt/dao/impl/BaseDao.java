package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.bjsxt.util.DBUtil;

public abstract class BaseDao {

	/**
	 * 执行DML的统一方法
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	protected boolean update(String sql, Object... args) {
		// 声明数据库连接
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		DBUtil.bindParam(pstmt, args);
		try {
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, pstmt, conn);
		}
		return false;
	}

	/**
	 * 执行DQL的统一方法
	 * 
	 * @param cls
	 * @param sql
	 * @param args
	 * @return
	 */
	protected <T> List<T> query(Class<T> cls, String sql, Object... args) {
		List<T> list = new ArrayList<T>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		ResultSet rs = null;
		DBUtil.bindParam(pstmt, args);
		try {
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				T bean = cls.newInstance();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					//就是将数据库取到的数据赋值给对象bean
					BeanUtils.setProperty(bean, metaData.getColumnLabel(i + 1), rs.getObject(i + 1));
				}
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	/**
	 * 查询数量的方法
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	protected int queryCount(String sql, Object... args) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		ResultSet rs = null;
		DBUtil.bindParam(pstmt, args);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return 0;
	}
}
