package com.zjl.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/** 
* 描述：volatile关键字不能保证原子性
* @author zhengjinlei 
* @version 2018年12月25日 下午2:55:42 
*/
public class VolatileTest02 extends Thread{
	//private volatile static int num;
	private static AtomicInteger num = new AtomicInteger(0);
	private static /*synchronized*/ void addCount(){
		for(int i=0; i<1000; i++){
			//num++;
			num.incrementAndGet();
		}
		System.out.println(num);
	}
	@Override
	public void run() {
		addCount();
	}
	public static void main(String[] args) {
		VolatileTest02[] arr = new VolatileTest02[10];
		for(int i=0; i<10; i++){
			arr[i] = new VolatileTest02();
		}
		for(int i=0; i<10; i++){
			arr[i].start();
		}
	}
}

