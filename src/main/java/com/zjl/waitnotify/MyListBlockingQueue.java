package com.zjl.waitnotify;
/** 
* 描述：通过wait/notify模拟queue的存取元素
* @author zhengjinlei 
* @version 2018年12月25日 下午4:29:04 
*/

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyListBlockingQueue {
	private final LinkedList<Object> list = new LinkedList<Object>();
	private AtomicInteger count = new AtomicInteger(0);
	
	private final int minSize = 0;
	private final int maxSize;
	
	private final Object lock = new Object();
	
	public MyListBlockingQueue(int size){
		this.maxSize = size;
	}
	
	public void put(Object obj){
		synchronized (lock) {
			while(count.get() == maxSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(obj);
			count.getAndIncrement();
			System.out.println("元素："+obj+"被添加");
			lock.notify();
		}
	}
	
	public Object take(){
		Object obj = null;
		synchronized (lock) {
			while(count.get() == minSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			obj = list.removeFirst();
			System.out.println("元素："+obj+"被移除");
			count.getAndDecrement();
			lock.notify();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		final MyListBlockingQueue queue = new MyListBlockingQueue(5);
		queue.put("a");
		queue.put("b");
		queue.put("c");
		queue.put("d");
		queue.put("e");
		System.out.println("当前队列中元素个数："+queue.count.get());
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				queue.put("f");	
				queue.put("g");	
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				queue.take();	
				queue.take();	
			}
		}, "t2");
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}

