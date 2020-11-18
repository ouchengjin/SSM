package com.bjsxt.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.utils.JavaFileUtils;
import com.bjsxt.sorm.utils.StringUtils;

/**
 * 这里的代码工作中用不到
 * @ClassName: TableContext
 * @Description:负责获取管理数据库所有表结构和类结构的关系，并
 * 可以根据表结构生成类结构
 * @author Alan Ouyang
 * @date 2020-06-16 22:15:28
 */
public class TableContext {
	/**
	 * 表名为key，表信息对象为value
	 */
	public static Map<String,TableInfo> tables = new HashMap<String, TableInfo>();
	/**
	 * 将po的Class对象和表信息对象关联起来，便于重用
	 */
	public static Map<Class,TableInfo> poClassTableMap = new HashMap<Class, TableInfo>();
	
	private TableContext(){};
	static{
		try {
			//初始化获得表的信息
			Connection conn = DBManager.getConn();
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet tableRet = dbmd.getTables(null, "%","%", new String[]{"TABLE"});
			
			while(tableRet.next()){
				String tableName = (String)tableRet.getObject("TABLE_NAME");
				TableInfo ti = new TableInfo(tableName, new ArrayList<ColumnInfo>(), new HashMap<String, ColumnInfo>());
				tables.put(tableName, ti);
				
				ResultSet set = dbmd.getColumns(null, "%", tableName, "%");
				while(set.next()){
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"), set.getString("TYPE_NAME"), 0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}
				
				ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);
				while(set2.next()){
					ColumnInfo ci2 = ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);//设置为主键类型
					ti.getPriKeys().add(ci2);
				}
				if(ti.getPriKeys().size()>0){//取唯一主键，方便使用，如果是联合主键，则为空
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//更新类结构
		updateJavaPOFile();
		//加载po包下面的所有的类便于重用提高效率
		loadPOTables();
	}
	/**
	 * 根据表结构更新配置的po包下面的java类
	 * 实现了从表结构转化为类结构
	 */
	public static void updateJavaPOFile(){
		Map<String, TableInfo> tables = TableContext.tables;	
		for (TableInfo tableInfo : tables.values()) {
			MySqlTypeConvertor mySqlTypeConvertor = new MySqlTypeConvertor();
			JavaFileUtils.createJavaFile(tableInfo, mySqlTypeConvertor);
		}
	}
	/**
	 * 
	 * @Title: loadPOTables
	 * @Description: 加载po包下面的类
	 * @author Alan Ouyang
	 * @date 2020-06-19 09:39:15
	 */
	public static void loadPOTables(){
		for (TableInfo tableInfo : tables.values()) {
			Class<?> c = null;;
			try {
				c = Class.forName(DBManager.getConf().getPoPackage()+"."
						+StringUtils.firstChar2UpperCase(tableInfo.gettName()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			poClassTableMap.put(c, tableInfo);
			
		}
	}
	
	public static void main(String[] args) {
		Map<String, TableInfo> tableInfos = TableContext.tables;
		System.out.println(tableInfos.size());
		for(String key:tableInfos.keySet()){
			System.out.println(key+"--"+tableInfos.get(key));
		}
	}
}
