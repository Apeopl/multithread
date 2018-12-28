package com.zjl.queue;

import java.util.concurrent.PriorityBlockingQueue;

/** 
* 描述：PriorityBlockingQueue,基于优先级的无界阻塞队列，传入队列的对象需要实现Comparable接口
* @author zhengjinlei 
* @version 2018年12月26日 上午11:02:29 
*/
public class PrioryQueueTest {
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<People> q = new PriorityBlockingQueue<People>();
		People p1 = new People(12,"zhang");
		People p2 = new People(26,"li");
		People p3 = new People(24,"liu");
		People p4 = new People(16,"niu");
		People p5 = new People(8,"niu");
		
		q.offer(p1);
		q.offer(p2);
		q.offer(p3);
		q.offer(p4);
		q.offer(p5);
		q.take();
		for (People people : q) {
			System.out.println(people);
		}
	}
}

