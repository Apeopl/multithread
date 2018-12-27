package com.zjl.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
* 描述：CyclicBarrier：等待所有线程准备好，开始执行
* @author zhengjinlei 
* @version 2018年12月27日 下午3:42:03 
*/
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new Sporter(barrier, "zhangsan"));
		executor.submit(new Sporter(barrier, "lisi"));
		executor.submit(new Sporter(barrier, "wangwu"));
		executor.shutdown();
	}

}
class Sporter implements Runnable{
	private CyclicBarrier barrier;
	private String name;
	
	public Sporter(CyclicBarrier barrier, String name){
		this.barrier = barrier;
		this.name = name;
	}

	public void run() {
		try {
			Thread.sleep(1000 * (new Random().nextInt(5)));
			System.out.println(name + "准备好了。。。");
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name + "开始。。。");
	}
	
}

