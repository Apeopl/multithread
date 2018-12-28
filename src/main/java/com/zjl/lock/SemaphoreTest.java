package com.zjl.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** 
* 描述：Semaphore信号量限流
* @author zhengjinlei 
* @version 2018年12月27日 下午4:36:45 
*/
public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(5);
		for(int index=0; index<20; index++){
			final int num = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("授权："+num);
						Thread.sleep((long) (Math.random()*10000));
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			executor.submit(run);
		}
		
		executor.shutdown();
	}
}

