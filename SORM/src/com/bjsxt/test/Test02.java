package com.bjsxt.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bjsxt.sorm.core.DBManager;
import com.bjsxt.sorm.core.QueryFactory;
import com.bjsxt.sorm.pool.DBconnPool;
import com.bjsxt.vo.Empvo;
/**
 * 测试连接池的效率
 * @ClassName: Test02
 * @author Alan Ouyang
 * @date 2020-06-21 15:27:02
 */
public class Test02 {
	
	public static void test01(){
		String sql2="select e.id,e.empname,e.salary+e.bonus 'xinshui',age,d.dname 'deptName',"
				+ "d.address 'deptAddr' from emp e INNER JOIN dept d on e.deptId = d.id";
		List<Empvo> queryRows2 = QueryFactory.getFactory().createQuery().queryRows(sql2, Empvo.class, null);
		System.out.println(queryRows2);
		for (Empvo object : queryRows2) {
			System.out.println(object.getDeptAddr()+"---"+object.getXinshui()+"---"+object.getDeptName());
		}

	}

	public static void main(String[] args) {

		long startTime= System.currentTimeMillis();
		for(int i=0;i<3000;i++){
			test01();
		}
		long endTime= System.currentTimeMillis();
		System.out.println(endTime-startTime);//不加连接池时4781ms,加连接池时1199ms
		
//		DBconnPool dBconnPool = new DBconnPool();
//		long startTime2= System.currentTimeMillis();
//		for(int i=0;i<100;i++){
//			Connection conn = dBconnPool.getConnection();
//			dBconnPool.close(conn);
//		}
//		long endTime2= System.currentTimeMillis();
//		System.out.println(endTime2-startTime2);
	}

}
