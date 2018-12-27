package com.zjl.providerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月27日 上午10:16:15 
*/
public class ProviderConsumerTest {

	public static void main(String[] args) {
		//内存缓冲区
		BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>();
		//生产者
		Provider p1 = new Provider(queue);
		Provider p2 = new Provider(queue);
		Provider p3 = new Provider(queue);
		
		//消费者
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		threadPool.execute(p1);
		threadPool.execute(p2);
		threadPool.execute(p3);
		threadPool.execute(c1);
		threadPool.execute(c2);
		threadPool.execute(c3);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		p1.stop();
		p2.stop();
		p3.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

