package com.bjsxt.pojo;

import java.util.List;

public class Users {
	private Integer id;
	private String uname;
	private String upwd;
	private List<Menu> list;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public List<Menu> getList() {
		return list;
	}
	public void setList(List<Menu> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", uname=" + uname + ", upwd=" + upwd + ", list=" + list + "]";
	}
	
	
	
}
