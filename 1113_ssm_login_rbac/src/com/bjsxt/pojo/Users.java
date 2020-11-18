package com.bjsxt.pojo;

import java.util.List;

public class Users {
	private Integer id;
	private String uname;
	private String upwd;
	private Integer rid;//角色编号
	private List<Menu> list;//存放当前用户所有的菜单
	private List<Path> plist;//存放当前用户所有可以访问的url
	public List<Path> getPlist() {
		return plist;
	}
	public void setPlist(List<Path> plist) {
		this.plist = plist;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
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
