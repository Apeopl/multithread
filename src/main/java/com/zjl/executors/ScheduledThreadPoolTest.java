package com.zjl.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** 
* 描述：执行定时任务的线程池ScheduledThreadPool
* @author zhengjinlei 
* @version 2018年12月27日 下午1:43:40 
*/
public class ScheduledThreadPoolTest {

	public static void main(String[] args) {
		Task task = new Task();
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
		//scheduledThreadPool.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
		scheduledThreadPool.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);
	}

}
class Task implements Runnable{
	public void run() {
		System.out.println("run...");
	}
}
