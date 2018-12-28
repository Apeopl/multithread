package com.zjl.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/** 
* 描述：自定义线程池（有界队列/无界队列）
* @author zhengjinlei 
* @version 2018年12月27日 下午2:07:30 
*/
public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
											2, 
											2, 
											60, 
											TimeUnit.SECONDS, 
											new ArrayBlockingQueue<Runnable>(3), 
											//new LinkedBlockingQueue<Runnable>()
											//threadFactory, 
											new DiscardOldestPolicy()
											);
		MyTask t1 = new MyTask(1, "任务1");
		MyTask t2 = new MyTask(2, "任务2");
		MyTask t3 = new MyTask(3, "任务3");
		MyTask t4 = new MyTask(4, "任务4");
		MyTask t5 = new MyTask(5, "任务5");
		MyTask t6 = new MyTask(6, "任务6");
		
		threadPool.submit(t1);
		threadPool.submit(t2);
		threadPool.submit(t3);
		threadPool.submit(t4);
		threadPool.submit(t5);
		threadPool.submit(t6);
		
		threadPool.shutdown();
	}

}
class MyTask implements Runnable{
	private int id;
	private String name;

	public MyTask(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("任务"+this.id+"执行了。。。");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
