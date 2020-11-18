package com.bjsxt.sorm.core;
/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @ClassName: DBManager
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-16 22:18:20
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.bjsxt.sorm.bean.Configuration;
import com.bjsxt.sorm.pool.DBconnPool;

public class DBManager {
	/**
	 * 配置信息
	 */
	private static Configuration conf;
	/**
	 * 连接池对象
	 */
	private static  DBconnPool pool;
	static {//静态代码块
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		
		
	}
	/**
	 * 获得Connection对象
	 * @Title: getConn
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:22:38
	 */
	public static Connection getConn() {
		if(pool==null){
			pool = new DBconnPool();
		}
		Connection conn = pool.getConnection();
		return conn;
		
	}
	
	/**
	 * 创建Connection对象
	 * @Title: getConn
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:22:38
	 */
	public static Connection creatConn() {
		Connection conn;
		try {
			Class.forName(conf.getDriver());
			conn = DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
			return conn;//直接建立连接，后期增加连接池处理，提高效率
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 关闭传入的ResultSet ,Statement ,Connection对象
	 * @Title: close
	 * @param executeQuery
	 * @param statement
	 * @param conn
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:23:35
	 */
	public static void close(ResultSet executeQuery,Statement statement,Connection conn) {
		try {
			if(executeQuery!=null) {
				executeQuery.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement!=null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		pool.close(conn);
		
	}
	/**
	 * 关闭传入的Statement ,Connection对象
	 * @Title: close
	 * @param statement
	 * @param conn
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:24:43
	 */
	public static void close(Statement statement,Connection conn) {
		
		try {
			if(statement!=null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pool.close(conn);
	}
	
	public static void close(Connection conn) {
		pool.close(conn);
	}
	/**
	 * 返回Configuration对象
	 * @return
	 */
	public static Configuration getConf() {
		return conf;
	}
	
}
