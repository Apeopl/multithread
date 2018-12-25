package com.zjl.synchronizedtest;
/** 
* 描述：对象锁的同步和异步
* @author zhengjinlei 
* @version 2018年12月25日 上午10:15:35 
*/
public class SynchronizedTest02 {
	public synchronized void method01(){
		try {
			System.out.println("method01:"+Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 如果此方法不加synchronized，此方法可以异步执行
	 * 如果加了synchronized，在同一把对象锁上只能同步执行
	 */
	public synchronized void method02(){
		System.out.println("method02:"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		final SynchronizedTest02 st = new SynchronizedTest02();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				st.method01();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				st.method02();
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}

