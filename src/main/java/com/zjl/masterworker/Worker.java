package com.zjl.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 下午4:51:02 
*/
public class Worker implements Runnable {
	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String, Object> resultMap;

	public void run() {
		while(true){
			Task input = this.workQueue.poll();
			if(input == null) break;
			Object obj = handle(input);
			this.resultMap.put(Integer.toString(input.getId()), obj);
		}
	}

	private Object handle(Task input) {
		Object obj = null;
		try {
			Thread.sleep(500);
			obj = input.getPrice();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

}

