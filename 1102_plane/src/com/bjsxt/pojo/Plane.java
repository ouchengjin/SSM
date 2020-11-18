package com.bjsxt.pojo;

public class Plane {
	private Integer id;
	private String ptype;
	private Integer time;
	private Double price;
	private Integer sid;
	private Integer eid;
	//因为只有2个机场，所以不用list，用了两个成员变量
	private Airport startPort;//起飞机场
	private Airport endPort;//降落机场
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Airport getStartPort() {
		return startPort;
	}
	public void setStartPort(Airport startPort) {
		this.startPort = startPort;
	}
	public Airport getEndPort() {
		return endPort;
	}
	public void setEndPort(Airport endPort) {
		this.endPort = endPort;
	}
	
	

}
