package com.bjsxt.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.utils.JDBCUtils;
import com.bjsxt.sorm.utils.ReflectUtils;

/**
 * 
 * @ClassName: Query
 * @Description: 负责查询（对外提供服务的核心类）
 * @author Alan Ouyang
 * @date 2020-06-16 21:31:04
 */
@SuppressWarnings("all")
public abstract class Query implements Cloneable{
	/**
	 * 采用模板方法模式将JDBC操作封装成模板，便于重用
	 * @Title: executeQueryTemplate
	 * @param sql SQL语句
	 * @param params sql的参数	
	 * @param clazz 记录要封装到的java类
	 * @param back CallBack的实现类，实现回调
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-20 18:00:16
	 */
	public Object executeQueryTemplate(String sql,Object[] params,Class clazz,CallBack back){
		Connection conn = DBManager.getConn();
		int count = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql设参数
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			return back.doExecute(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}finally{
			DBManager.close(rs, ps, conn);
		}
	}
	/**
	 * @Title: executeDML
	 * @Description:直接执行一个DML语句
	 * @param sql sql语句
	 * @param params 参数
	 * @return 执行sql语句后影响记录的行数
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:34:06
	 */
	public int executeDML(String sql,Object[] params){

		Connection conn = DBManager.getConn();
		int count = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql设参数
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(ps, conn);
		}
		return count;
	};
	/**
	 * @Title: insert
	 * @Description: 将一个对象存储到数据库中
	 * 把对象中不为null的属性往数据库中存储，如果数字为null，放0 
	 * @param obj 要存储的对象
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:37:59
	 */
	public void insert(Object obj){

		//obj--->表中。insert into 表名 (id,name,pwd) values (?,?,?)
		Class<? extends Object> c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		String tableName = tableInfo.gettName();
		StringBuffer sql = new StringBuffer();
		List<Object> params= new ArrayList<Object>();//存储sql的参数对象的值
		
		sql.append("insert into "+tableName+"(");
		Field[] fields = c.getDeclaredFields();
		int filedNumNotnull = 0;//用来记录非空的个数，以后用于插入？的个数
		for (Field field : fields) {
			String name = field.getName();
			Object fileValue = ReflectUtils.invokeGet(name, obj);
			if(fileValue!= null){
				sql.append(name+",");
				params.add(fileValue);
				filedNumNotnull++;
			}
		}
		sql.setCharAt(sql.length()-1, ')');
		sql.append("values (");
		for(int i=0;i<filedNumNotnull;i++){
			sql.append("?,");
		}
		sql.setCharAt(sql.length()-1, ')');
		executeDML(sql.toString(), params.toArray());
		
	
	}
	/**
	 * @Title: delete
	 * @Description: 删除clazz表示类对应的表中的记录（指定主键值id的记录）
	 * @param clazz 和表对应的类的Class对象
	 * @param id 主键的值
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:40:11
	 */
	public void delete(Class clazz,Object id){

		//Emp.class, 2--->delete  from emp where id = 2;
		//通过Class对象找TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		//获得主键
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		String sql = "delete from "+tableInfo.gettName()
		+" where "+onlyPriKey.getName()+"=?";
		int num = executeDML(sql, new Object[]{id});
		System.out.println("删除了"+num+"条信息");
		
	
	}
	/**
	 * @Title: delete
	 * @Description:删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj 
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:43:46
	 */
	public void delete(Object obj){
		Class<? extends Object> c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();//主键
		//通过反射机制，调用属性对应的set方法和get方法
		Object invokeGet = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c, invokeGet);
	}
	/**
	 * @Title: update
	 * @Description: 更新对象对应的记录，并且只更新指定的字段的值
	 * @param object 所要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return 执行SQL语句后影响记录的行数
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:48:22
	 */
	public int update(Object obj,String[] fieldNames){

		//obj{"uname","pwd"}----->update 表名 set uname = ?, pwd = ? where id =?
		Class<? extends Object> c = obj.getClass();
		List<Object> params= new ArrayList<Object>();//存储sql的参数对象的值
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();//获得唯一主键
		StringBuffer sql = new StringBuffer();
		String tableName = tableInfo.gettName();
		sql.append("update "+ tableName+" set ");
		Object onlyPriKeyvalue=ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		for (String fieldName : fieldNames) {
			sql.append(fieldName+" = ?,");
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			params.add(fieldValue);
		}
		sql.setCharAt(sql.length()-1, ' ');;
		sql.append("where "+onlyPriKey.getName()+"=?");
		params.add(onlyPriKeyvalue);//主键的值
		int num = executeDML(sql.toString(), params.toArray());
		System.out.println("更新了条"+num+"记录");
		return num;
	}
	
	
	/**
	 * @Title: queryRows
	 * @Description: 查询返回多行记录，并将每行记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params SQL的参数
	 * @return 查询到的结果
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:53:40
	 */
	public List queryRows(final String sql,final Class clazz,final Object[] params){
		
		return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				List list=null;
				try {
					ResultSetMetaData metaData = rs.getMetaData();
					//多行
					while(rs.next()){
						if(list==null){
							list = new ArrayList();
						}
						Object rowObj = clazz.newInstance();//调用javabean无参构造器
						//多列 select username,pwd,age from user where 	id>	? and age >18;
						for(int i=0;i<metaData.getColumnCount();i++){
							String columnName = metaData.getColumnLabel(i+1);
							Object columnValue = rs.getObject(i+1);
							//调用rowOb的setUserName(String uname)方法,将columnValue的值设置进去
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}
						list.add(rowObj);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return list;
			}
		});

	}
	/**
	 * @Title: queryUniqueRow
	 * @Description: 查询一行记录，并将该行记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params SQL的参数
	 * @return 查询到的结果
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:53:40
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params){
		List list = queryRows(sql, clazz, params);
		return (list!=null&&list.size()>0)?list.get(0):null;
	}
	/**
	 * @Title: queryValue
	 * @Description: 查询返回一个值（一行一列），并将该值返回
	 * @param sql 查询语句
	 * @param params SQL的参数
	 * @return 查询到的结果
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:53:40
	 */
	public Object queryValue(final String sql,final Object[] params){
		
		return executeQueryTemplate(sql, params, null, new CallBack() {//当参数类型为引用类型，又不需要传参的时候写null;
			
			/**
			 * 写这种接口实现类（匿名内部类时），需要先看调用此方法处传的参数，再写此处匿名内部类的实现
			 * @Title: doExecute
			 * @param conn
			 * @param ps
			 * @param rs
			 * @return 
			 * @see com.bjsxt.sorm.core.CallBack#doExecute(java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet) 
			 * @author Alan Ouyang
			 * @date 2020-06-20 17:47:07
			 */
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value= null;//存储查询结果
				
				try {
					while(rs.next()){
						if (value==null){
							value = new Object();
						}
						value= rs.getObject(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					DBManager.close(rs, ps, conn);
				}
				return value;
			}
		});
	}
	
	/**
	 * @Title: queryNumber
	 * @Description: 查询返回一个数字（一行一列），并将该值返回
	 * @param sql 查询语句
	 * @param params SQL的参数
	 * @return 查询到的数字
	 * @author Alan Ouyang
	 * @date 2020-06-16 21:53:40
	 */
	public Number queryNumber(String sql,Object[] params){
		return (Number)queryValue(sql, params);
	}
	/**
	 * 分页查询
	 * @Title: queryPagename
	 * @param pageNum 第几页数据
	 * @param size 每页显示多少记录
	 * @return
	 * @author Alan Ouyang
	 * @date 2020-06-20 14:14:35
	 */
	public abstract Object queryPagename(int pageNum,int size);
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
