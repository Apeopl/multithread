package com.zjl.lock;

import java.util.concurrent.CountDownLatch;

/** 
* 描述：CountDownLatch：等待其他线程执行后通知本线程执行
* @author zhengjinlei 
* @version 2018年12月27日 下午3:26:28 
*/
public class CountDownLatchTest {
	public static void main(String[] args) {
		final CountDownLatch lock = new CountDownLatch(2);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("进入t1线程，等待其他线程处理完毕。。。");
					lock.await();
					System.out.println("t1线程继续执行。。。");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("进入t2线程。。。");
					Thread.sleep(1000);
					System.out.println("t2线程通知t1线程。。。");
					lock.countDown();;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t3");
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("进入t3线程。。。");
					Thread.sleep(1000);
					System.out.println("t3线程通知t1线程。。。");
					lock.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

