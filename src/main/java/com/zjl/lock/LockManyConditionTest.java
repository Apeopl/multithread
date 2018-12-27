package com.zjl.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
* 描述：一个Lock多个Condition
* @author zhengjinlei 
* @version 2018年12月27日 下午5:14:47 
*/
public class LockManyConditionTest {
	private Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	public void method1(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入method1。。。");
			Thread.sleep(2000);
			System.out.println("线程"+Thread.currentThread().getName()+"释放锁method1。。。");
			c1.await();
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行method1。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void method2(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入method2。。。");
			Thread.sleep(2000);
			System.out.println("线程"+Thread.currentThread().getName()+"释放锁method2。。。");
			c1.await();
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行method2。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void method3(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入method3。。。");
			Thread.sleep(2000);
			System.out.println("线程"+Thread.currentThread().getName()+"释放锁method3。。。");
			c2.await();
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行method3。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void method4(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入method4。。。");
			System.out.println("线程"+Thread.currentThread().getName()+"唤醒method4。。。");
			c1.signalAll();
			Thread.sleep(2000);
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行method4。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void method5(){
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入method5。。。");
			System.out.println("线程"+Thread.currentThread().getName()+"唤醒method5。。。");
			c2.signal();
			Thread.sleep(2000);
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行method5。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final LockManyConditionTest lmc = new LockManyConditionTest();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				lmc.method1();
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				lmc.method2();
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				lmc.method3();
			}
		},"t3");
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				lmc.method4();
			}
		},"t4");
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				lmc.method5();
			}
		},"t5");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t4.start();
		t5.start();
	}
}

