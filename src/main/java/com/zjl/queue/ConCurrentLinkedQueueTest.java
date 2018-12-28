package com.zjl.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/** 
* 描述：ConCurrentLinkedQueue
* @author zhengjinlei 
* @version 2018年12月26日 上午10:14:15 
*/
public class ConCurrentLinkedQueueTest {
	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		queue.add("a");
		queue.add("b");
		queue.offer("c");
		queue.add("d");
		
		System.out.println(queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
	}
}

