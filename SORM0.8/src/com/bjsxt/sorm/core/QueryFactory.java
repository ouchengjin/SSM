package com.bjsxt.sorm.core;
/**
 * 创建Query对象的工厂类
 * @ClassName: QueryFactory
 * @author Alan Ouyang
 * @date 2020-06-20 21:35:31
 */
public class QueryFactory {
	private static QueryFactory factory = new QueryFactory();
	private static Query prototypeObj=null;//原型对象
	static {
		try {
			//加载指定的query类
			Class<?> c = Class.forName(DBManager.getConf().getQueryClass());
			prototypeObj = (Query) c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	private QueryFactory() {//私有构造器
	}
	
	public static QueryFactory getFactory(){
		return factory;
	}
	public   Query createQuery() {
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
