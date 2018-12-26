package com.zjl.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/** 
* 描述：ArrayBlockingQueue基于数组实现的阻塞队列
* @author zhengjinlei 
* @version 2018年12月26日 上午10:22:55 
*/
public class ArrayBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(3);
		q.offer("a");
		q.add("b");
		q.put("c");
		
		//boolean flag = q.offer("d");
		boolean flag = q.offer("f", 2, TimeUnit.SECONDS);
		
		q.poll();
		
		System.out.println(flag);
	}
}

