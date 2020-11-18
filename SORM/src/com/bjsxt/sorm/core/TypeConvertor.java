package com.bjsxt.sorm.core;
/**
 * 
 * @ClassName: TypeConvertor
 * @Description: 负责java数据类型和数据库数据类型的互相转换
 * @author Alan Ouyang
 * @date 2020-06-16 22:07:33
 */
public interface TypeConvertor {
	/**
	 * @Title: databaseType2JavaType
	 * @Description: 将数据库数据类型转化为java的数据类型
	 * @param columnType 数据库字段的数据类型
	 * @return java的数据类型
	 * @author Alan Ouyang
	 * @date 2020-06-16 22:10:51
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * @Title: JavaType2DatabaseType
	 * @Description: 将java的数据类型转化为数据库数据类型
	 * @param javaDataType java数据类型
	 * @return 数据库类型
	 * @author Alan Ouyang
	 * @date 2020-06-16 22:10:51
	 */
	public String JavaType2DatabaseType(String javaDataType);
}
