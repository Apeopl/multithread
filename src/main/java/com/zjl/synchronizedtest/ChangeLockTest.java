package com.zjl.synchronizedtest;
/** 
* 描述：同步过程中改变了锁对象出现不同步的问题
* @author zhengjinlei 
* @version 2018年12月25日 下午2:21:50 
*/
public class ChangeLockTest {
	private String lock = "lock";
	public void method(){
		synchronized (lock) {
			try {
				lock = "other lock";
				System.out.println("当前线程："+Thread.currentThread().getName()+"开始。。。");
				Thread.sleep(1000);
				System.out.println("当前线程："+Thread.currentThread().getName()+"结束。。。");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		final ChangeLockTest ct = new ChangeLockTest();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				ct.method();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				ct.method();
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}

