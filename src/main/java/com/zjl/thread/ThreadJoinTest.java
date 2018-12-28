package com.zjl.thread;
/** 
* 描述：Thread.join()：当前线程需等待thread线程终止之后才从thread.join()返回
* @author zhengjinlei 
* @version 2018年12月28日 下午2:35:27 
*/
public class ThreadJoinTest {
	public static void main(String[] args) {
		Thread prev = Thread.currentThread();
		for(int i=0; i<10; i++){
			Thread thread = new Thread(new JoinThread(prev),"线程"+String.valueOf(i));
			thread.start();
			prev = thread;
		}
		System.out.println(Thread.currentThread().getName()+"终止！");
	}
}
class JoinThread implements Runnable{
	private Thread thread;
	
	public JoinThread(Thread thread){
		this.thread = thread;
	}

	public void run() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"终止！");
	}
	
}
