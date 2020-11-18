package com.bjsxt.sorm.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.po.Emp;
import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.utils.JDBCUtils;
import com.bjsxt.sorm.utils.ReflectUtils;
import com.bjsxt.sorm.utils.StringUtils;
import com.bjsxt.vo.Empvo;
/**
 * @ClassName: MySqlQuery
 * @Description: 负责对于MySQL数据库的查询
 * @author Alan Ouyang
 * @date 2020-06-19 09:30:21
 */
public class MySqlQuery extends Query {

	public static void testDML(){
		Emp emp = new Emp();
		emp.setId(2);
		emp.setEmpname("Alan");
		emp.setAge(20);
		emp.setSalary(10000000.0);
		emp.setBonus(1000.0);
		emp.setBirthday(new Date(System.currentTimeMillis()));
		MySqlQuery mySqlQuery = (MySqlQuery) QueryFactory.getFactory().createQuery();
//		mySqlQuery.delete(emp);
//		mySqlQuery.insert(emp);
		mySqlQuery.update(emp, new String[]{"empname","age","salary","bonus"});
	}
	
	public static void testQueryRows(){
//		List queryRows = new MySqlQuery().queryRows("select empname,salary,age from emp where age>? and salary>?"
//				, Emp.class, new Object[]{18,100});
//		System.out.println(queryRows);
//		for (Object object : queryRows) {
//			Emp object1 =(Emp) object;
//			System.out.println(object1.getAge()+"---"+object1.getSalary());
//		}
		
		String sql2="select e.id,e.empname,e.salary+e.bonus 'xinshui',age,d.dname 'deptName',"
				+ "d.address 'deptAddr' from emp e INNER JOIN dept d on e.deptId = d.id";
		List<Empvo> queryRows2 = QueryFactory.getFactory().createQuery().queryRows(sql2, Empvo.class, null);
		System.out.println(queryRows2);
		for (Empvo object : queryRows2) {
			System.out.println(object.getDeptAddr()+"---"+object.getXinshui()+"---"+object.getDeptName());
		}
			
	}
	public static void testQueryUniqueRow(){
		Empvo object = (Empvo)QueryFactory.getFactory().createQuery().queryUniqueRow("select e.id,e.empname,e.salary+e.bonus "
				+ "'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
				+ "INNER JOIN dept d on e.deptId = d.id where e.id = ?", 
				Empvo.class, new Object[]{1});
		System.out.println(object.getDeptAddr()+"---"+object.getXinshui()+"---"+object.getDeptName());
		
	}
	
	public static void testQueryValue(){
		Object value = QueryFactory.getFactory().createQuery().queryValue("select count(*) from emp  where salary >= ?",
				new Object[]{1});
		System.out.println(value);
	}
	public static void testQueryNumber(){
		Number value = QueryFactory.getFactory().createQuery().queryNumber("select count(*) from emp  where salary >= ?",
				new Object[]{1});
		System.out.println(value.doubleValue());//利用这种方法随意转型
	}
	
	public static void main(String[] args) {
		
		testQueryValue();
	}

	@Override
	public Object queryPagename(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}




}
