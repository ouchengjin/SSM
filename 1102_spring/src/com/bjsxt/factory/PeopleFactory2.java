package com.bjsxt.factory;

import com.bjsxt.pojo.People;
/**
 * 实例工厂
 * @ClassName: PeopleFactory2
 * @author Alan Ouyang
 * @date 2020-07-13 15:14:33
 */
public class PeopleFactory2 {
	
	public PeopleFactory2() {
		System.out.println("PeopleFactory2被创建");
	}
	public static People getInstance(){
		return new People("小强",18);
	}
}
