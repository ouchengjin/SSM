package com.bjsxt.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.JavaFileGetSet;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.core.DBManager;
import com.bjsxt.sorm.core.MySqlTypeConvertor;
import com.bjsxt.sorm.core.TableContext;
import com.bjsxt.sorm.core.TypeConvertor;

/**
 * 
 * @ClassName: JavaFileUtils
 * @Description: 封装了生成Java文件（源代码）常用的操作
 * @author Alan Ouyang
 * @date 2020-06-16 22:23:17
 */
public class JavaFileUtils {

	/**
	 * 根据字段信息生产java属性信息。如varchar username--->private String username;
	 * @param column 字段信息	
	 * @param convertor 类型转换器
	 * @return java属性和set/get方法源码
	 */
	public static  JavaFileGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor){
		JavaFileGetSet jfgs= new JavaFileGetSet();
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
		//public String getUserName(){return username;}
		//生成get方法源代码
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+
				"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUserName(){this.username=username;}
		//生成set方法源代码
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void"+" set"+StringUtils.firstChar2UpperCase(column.getName())+
				"("+javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		
		return jfgs;
	}
	
	public static String createJavaSrc(TableInfo tableinfo,TypeConvertor convertor){
		Map<String, ColumnInfo> columns = tableinfo.getColumns();
		List<JavaFileGetSet> javaFields =  new ArrayList<JavaFileGetSet>();
		for(ColumnInfo c:columns.values()){
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		StringBuilder src = new StringBuilder();
		//生成package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//生成import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//生成类声明语句 
		src.append("public class "+StringUtils.firstChar2UpperCase(tableinfo.gettName())+" {\n\n");
		//生成属性列表 
		for(JavaFileGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		//生成get方法列表 
		for(JavaFileGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//生成set方法列表 
		for(JavaFileGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		//生成类结束
		src.append("}\n");
		return src.toString();
	}
	
	public static void createJavaFile(TableInfo tableinfo,TypeConvertor convertor){
		String createJavaSrc = createJavaSrc(tableinfo, convertor);
		String srcPath = DBManager.getConf().getSrcPath();
		String poPackage = DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\");
		String dirPath = srcPath+"/"+poPackage+"/";
		File file = new File(dirPath);
		if(!file.exists()){
			file.mkdirs();//如果指定目录不存在，帮助用户建立
		}
		File file2 = new File(dirPath,StringUtils.firstChar2UpperCase(tableinfo.gettName())+".java");
		BufferedWriter bw=null;
		try {
			bw = new BufferedWriter(new FileWriter(file2));
			bw.write(createJavaSrc);
			System.out.println("建立表"+tableinfo.gettName()+"对应的java类："+StringUtils.firstChar2UpperCase(tableinfo.gettName())+".java");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 测试
	 * @param args
	 */
//	public static void main(String[] args) {
//		Map<String, TableInfo> tables = TableContext.tables;	
//		for (TableInfo tableInfo : tables.values()) {
//			MySqlTypeConvertor mySqlTypeConvertor = new MySqlTypeConvertor();
//			JavaFileUtils.createJavaFile(tableInfo, mySqlTypeConvertor);
//		}
//	}
}
