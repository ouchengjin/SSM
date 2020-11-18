package com.bjsxt.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: TableInfo
 * @Description: 存储表结构的信息
 * @author Alan Ouyang
 * @date 2020-06-17 10:40:50
 */
public class TableInfo {
	/**
	 * 表名
	 */
	private String tName;
	/**
	 * 所有字段的信息
	 */
	private Map<String,ColumnInfo> columns;
	/**
	 * 唯一主键（目前我们只能处理表中有且只有一个主键的情况）
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 如果是联合主键，则在这里存储
	 */
	private List<ColumnInfo> priKeys;
	public TableInfo() {
	}
	public TableInfo(String tName, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tName = tName;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
	
	public TableInfo(String tName,List<ColumnInfo> priKeys,Map<String, ColumnInfo> columns) {
		super();
		this.tName = tName;
		this.columns = columns;
		this.priKeys = priKeys;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
}
