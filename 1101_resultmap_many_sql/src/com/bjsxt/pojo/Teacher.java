package com.bjsxt.pojo;

import java.util.List;

public class Teacher {
	private Integer id;
	private String name;
	private List<Student> list;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
	
	
	
	
}
