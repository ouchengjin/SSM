package com.bjsxt.pojo;

public class People {
	private String name;
	private Integer age;

	public People() {
		System.out.println("无参创建People");
	}
	
	public People(String name, Integer age) {
		System.out.println("有参创建People");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
	
}
