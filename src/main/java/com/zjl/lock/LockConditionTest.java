package com.zjl.lock;
/** 
* 描述：lock.newCondition()的await()方法和signal()方法
* @author zhengjinlei 
* @version 2018年12月27日 下午5:01:04 
*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {
	Lock lock = new ReentrantLock();
	Condition condition =  lock.newCondition();
	public void method1(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入等待。。。");
			Thread.sleep(3000);
			System.out.println("线程"+Thread.currentThread().getName()+"释放锁。。。");
			condition.await();
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void method2(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入。。。");
			Thread.sleep(3000);
			System.out.println("线程"+Thread.currentThread().getName()+"发出唤醒。。。");
			condition.signal();
			Thread.sleep(3000);
			System.out.println("线程"+Thread.currentThread().getName()+"执行完毕。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final LockConditionTest lc = new LockConditionTest();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				lc.method1();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				lc.method2();
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}

