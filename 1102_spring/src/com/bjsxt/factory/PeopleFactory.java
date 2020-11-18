package com.bjsxt.factory;

import com.bjsxt.pojo.People;
/**
 * 实例工厂
 * @ClassName: PeopleFactory
 * @author Alan Ouyang
 * @date 2020-07-13 15:03:29
 */
public class PeopleFactory {
	public PeopleFactory() {
		System.out.println("PeopleFactory工厂对象被创建");
	}
	public People getInstance(){
		return new People("xiaoming",18);
	}
}
