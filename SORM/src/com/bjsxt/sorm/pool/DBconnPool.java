package com.bjsxt.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bjsxt.sorm.core.DBManager;

/**
 * 连接池的类
 * @ClassName: DBconnPool
 * @author Alan Ouyang
 * @date 2020-06-21 14:12:55
 */
public class DBconnPool {

	/**
	 * 连接池对象
	 */
	private List<Connection> pool;
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();
	/**
	 * 初始化连接池，使池中连接数达到标准范围的最小值POOL_MIN_SIZE
	 * @Title: initPool
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:30:09
	 */
	public void initPool(){
		
		if(pool==null){
			pool = new ArrayList<Connection>();
		}
		
		while(pool.size()<POOL_MIN_SIZE){
			pool.add(DBManager.creatConn());
			System.out.println("初始化数据库连接池，池中连接数为："+pool.size());
		}
	}
	/**
	 * 从连接池中取出一个连接
	 * @Title: getConnection
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:43:57
	 */
	public synchronized Connection getConnection(){
		int last_index = pool.size()-1;
		Connection conn = pool.get(last_index);
		
		pool.remove(last_index);
		return conn;
	}
	/**
	 * 将连接放回池中
	 * @Title: close
	 * @param conn
	 * @author Alan Ouyang
	 * @date 2020-06-21 14:48:41
	 */
	public synchronized void close(Connection conn){
		if(pool.size()>POOL_MAX_SIZE){
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			pool.add(conn);
		}
	}
	public DBconnPool() {
		initPool();
	}
	
}
