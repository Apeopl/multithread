package com.zjl.synchronizedtest;
/** 
* 描述：synchronized锁重入
* @author zhengjinlei 
* @version 2018年12月25日 上午11:10:25 
*/
public class SynchronizedTest04 {
	public synchronized void method1(){
		System.out.println("method1...");
		method2();
	}
	public synchronized void method2(){
		System.out.println("method2...");
		method3();
	}
	public synchronized void method3(){
		System.out.println("method3...");
	}
	public static void main(String[] args) {
		final SynchronizedTest04 st = new SynchronizedTest04();
		Thread t = new Thread(new Runnable() {
			public void run() {
				st.method1();
			}
		});
		t.start();
	}
}

