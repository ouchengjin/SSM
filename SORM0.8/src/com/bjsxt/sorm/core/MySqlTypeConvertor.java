package com.bjsxt.sorm.core;
/**
 * mysql数据类型和java数据类型的转换
 * @author aaron
 *
 */
public class MySqlTypeConvertor implements TypeConvertor {

	/**
	 * varchar和char----》String
	 */
	@Override
	public String databaseType2JavaType(String columnType) {
		if("varchar".equalsIgnoreCase(columnType)||"char".equalsIgnoreCase(columnType)){
			return "String";
		}else if("int".equalsIgnoreCase(columnType)
				||"tinyint".equalsIgnoreCase(columnType)
				||"smallint".equalsIgnoreCase(columnType)
				||"integer".equalsIgnoreCase(columnType)
				){
			return "Integer";
		}else if("bigint".equalsIgnoreCase(columnType)){
			return "Long";
		}else if("double".equalsIgnoreCase(columnType)){
			return "Double";
		}else if("float".equalsIgnoreCase(columnType)){
			return "Float";
		}else if("float".equalsIgnoreCase(columnType)){
			return "Float";
		}else if("blob".equalsIgnoreCase(columnType)){
			return "java.sql.Blob";
		}else if("date".equalsIgnoreCase(columnType)){
			return "java.sql.Date";
		}else if("time".equalsIgnoreCase(columnType)){
			return "java.sql.Time";
		}else if("timeStamp".equalsIgnoreCase(columnType)){
			return "java.sql.TimeStamp";
		}
		long dahd;
		 
		return null;
	}

	@Override
	public String JavaType2DatabaseType(String javaDataType) {
		// TODO Auto-generated method stub
		return null;
	}

}
