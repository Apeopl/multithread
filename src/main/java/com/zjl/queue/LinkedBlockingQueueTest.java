package com.zjl.queue;

import java.util.concurrent.LinkedBlockingQueue;

/** 
* 描述：LinkedBlockingQueue基于链表实现的无界阻塞队列，也可以给定初始化容量
* @author zhengjinlei 
* @version 2018年12月26日 上午10:32:35 
*/
public class LinkedBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>(4);
		q.add("a");
		q.offer("b");
		q.put("c");
		q.add("e");
		q.offer("f");
		//q.offer("g");
		
		System.out.println(q.size());
		for (String str : q) {
			System.out.println(str);
		}
	}
}

