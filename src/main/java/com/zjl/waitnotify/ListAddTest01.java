package com.zjl.waitnotify;

import java.util.ArrayList;
import java.util.List;

/** 
* 描述：wait/notify实现线程间通信
* @author zhengjinlei 
* @version 2018年12月25日 下午3:37:05 
*/
public class ListAddTest01 {
	private static volatile List list = new ArrayList<String>();
	public void add(){
		list.add("zjl");
	}
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAddTest01 la = new ListAddTest01();
		final Object lock = new Object();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					for(int i=0; i<10; i++){
						la.add();
						System.out.println("线程"+Thread.currentThread().getName()+"向集合中添加元素");
						if(list.size() == 5){
							lock.notify();
							System.out.println("线程"+Thread.currentThread().getName()+"发出了通知");
						}
					}
				}
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					if(list.size()!=5){
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("线程"+Thread.currentThread().getName()+"收到了通知");
					throw new RuntimeException();
				}
			}
		}, "t2");
		t2.start();
		t1.start();
	}
}

