package com.zjl.queue;

import java.util.concurrent.SynchronousQueue;

/** 
* 描述：SynchronousQueue,一种没有缓冲的队列，生产者产生的数据会被消费者直接获取并消费
* @author zhengjinlei 
* @version 2018年12月26日 上午10:47:47 
*/
public class SynchronousQueueTest {
	public static void main(String[] args) throws InterruptedException {
		final SynchronousQueue<String> q = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println(q.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				q.add("zjl");
			}
		}, "t2");
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}

