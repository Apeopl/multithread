package com.zjl.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
* 描述：ReentrantLock重入锁
* @author zhengjinlei 
* @version 2018年12月27日 下午4:49:47 
*/
public class ReentrantLockTest {
	private Lock lock = new ReentrantLock();
	public void method1(){
		try {
			lock.lock();
			System.out.println("线程："+Thread.currentThread().getName()+"进入。。。");
			Thread.sleep(1000);
			System.out.println("线程："+Thread.currentThread().getName()+"退出。。。");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void method2(){
		try {
			lock.lock();
			System.out.println("线程："+Thread.currentThread().getName()+"进入。。。");
			Thread.sleep(2000);
			System.out.println("线程："+Thread.currentThread().getName()+"退出。。。");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final ReentrantLockTest test = new ReentrantLockTest();
		Thread t = new Thread(new Runnable() {
			public void run() {
				test.method1();
				test.method2();
			}
		},"t1");
		
		t.start();
	}
}

