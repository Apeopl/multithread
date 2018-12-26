package com.zjl.queue;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 上午11:03:29 
*/
public class People implements Comparable<People>{
	private int age;
	private String name;
	public People(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "People [age=" + age + ", name=" + name + "]";
	}
	public int compareTo(People o) {
		return this.age>o.age?1:(this.age<o.age?-1:0);
	}
	
}

