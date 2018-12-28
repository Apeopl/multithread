package com.zjl.providerconsumer;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月27日 上午10:02:56 
*/
public class Data {
	private String id;
	private String name;
	public Data(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		return "Data [id=" + id + ", name=" + name + "]";
	}
	
}

