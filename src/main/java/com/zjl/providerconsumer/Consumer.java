package com.zjl.providerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月27日 上午10:04:16 
*/
public class Consumer implements Runnable {
	private BlockingQueue<Data> queue;
	public Consumer(BlockingQueue<Data> queue){
		this.queue = queue;
	}
	private Random r = new Random();
	
	public void run() {
		while(true){
			try {
				Data data = this.queue.take();
				Thread.sleep(r.nextInt(1000));
				System.out.println("当前线程："+Thread.currentThread().getName()+"，消费成功，消费数据id是："+data.getId());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

