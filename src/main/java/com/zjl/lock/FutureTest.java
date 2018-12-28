package com.zjl.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/** 
* 描述：JDK提供的Future模式
* @author zhengjinlei 
* @version 2018年12月27日 下午4:07:45 
*/
public class FutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String queryStr = "查询";
		FutureTask<String> future = new FutureTask<String>(new MyFuture(queryStr));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future f = executor.submit(future);
		System.out.println("请求完毕。。。");
		/*try {
			Thread.sleep(4000);
			System.out.println(f.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}*/
		System.out.println(future.get());
		
		executor.shutdown();
	}
}
class MyFuture implements Callable<String> {
	private String params;
	
	public MyFuture(String params){
		this.params = params;
	}
	
	public String call() throws Exception {
		Thread.sleep(2000);
		return this.params + "处理完毕。。。";
	}
}
