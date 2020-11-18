package com.bjsxt.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类
 * 
 * @author Administrator
 *
 */
public class DBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	static {
		// 创建Properties对象
		Properties prop = new Properties();
		try {
			// 加载配置文件
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			// 读取数据库类型
			String dbtype = prop.getProperty("dbtype").trim();
			// 读取信息并赋值
			driver = prop.getProperty("jdbc." + dbtype + "driver").trim();
			url = prop.getProperty("jdbc." + dbtype + "url").trim();
			username = prop.getProperty("jdbc." + dbtype + "username").trim();
			password = prop.getProperty("jdbc." + dbtype + "password").trim();
			// 加载驱动
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("DBUtil.getConn(连接获取失败, 请检查:[url:" + url + "], [username:" + username + "], [password:"
					+ password + "])");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获取预处理发送器
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPstmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * 动态绑定参数
	 * 
	 * @param pstmt
	 * @param args
	 */
	public static void bindParam(PreparedStatement pstmt, Object... args) {
		try {
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i + 1, args[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 统一关闭资源
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
