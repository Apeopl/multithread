package com.zjl.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/** 
* 描述：网民
* @author zhengjinlei 
* @version 2018年12月26日 下午2:06:49 
*/
public class WangMin implements Delayed{
	private int id;
	private String name;
	private long endTime;
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	
	public WangMin(int id, String name, long endTime) {
		this.id = id;
		this.name = name;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	/**
	 * 队列元素排序用
	 */
	public int compareTo(Delayed o) {
		WangMin w = (WangMin) o;
		return this.getDelay(this.timeUnit)-w.getDelay(this.timeUnit)>0?1:0;
	}

	/**
	 * 判断是否到了截止时间
	 */
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis();
	}

}

