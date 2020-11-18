package com.bjsxt.pojo;

public class Student {
	private Integer id;
	private String name;
	private Teacher teacher;
	
	
	
	public Student(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer id, String name, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
}
