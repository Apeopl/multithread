package com.zjl.waitnotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/** 
* 描述：CountDownLatch实现线程间通信
* @author zhengjinlei 
* @version 2018年12月25日 下午3:37:05 
*/
public class ListAddTest02 {
	private static volatile List list = new ArrayList<String>();
	public void add(){
		list.add("zjl");
	}
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAddTest02 la = new ListAddTest02();
		//final Object lock = new Object();
		final CountDownLatch latch = new CountDownLatch(1);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				//synchronized (lock) {
					for(int i=0; i<10; i++){
						la.add();
						System.out.println("线程"+Thread.currentThread().getName()+"向集合中添加元素");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(list.size() == 5){
							latch.countDown();
							System.out.println("线程"+Thread.currentThread().getName()+"发出了通知");
						}
					}
				//}
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				//synchronized (lock) {
					if(list.size()!=5){
						try {
							latch.await();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.println("线程"+Thread.currentThread().getName()+"收到了通知");
					throw new RuntimeException();
				//}
			}
		}, "t2");
		t2.start();
		t1.start();
	}
}

