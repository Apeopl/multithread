package com.zjl.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/** 
* 描述：读写锁ReentrantReadWriteLock：读读共享，读写互斥，写写互斥
* @author zhengjinlei 
* @version 2018年12月28日 上午9:20:52 
*/
public class ReentrantWriteReadLockTest {
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	ReadLock readLock = lock.readLock();
	WriteLock writeLock = lock.writeLock();
	
	public void read(){
		try {
			readLock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入。。。");
			Thread.sleep(3000);
			System.out.println("线程"+Thread.currentThread().getName()+"退出。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			readLock.unlock();
		}
	}
	
	public void write(){
		try {
			writeLock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"进入。。。");
			Thread.sleep(3000);
			System.out.println("线程"+Thread.currentThread().getName()+"退出。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			writeLock.unlock();
		}
	}
	

	public static void main(String[] args) {
		final ReentrantWriteReadLockTest wr = new ReentrantWriteReadLockTest();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				wr.read();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				wr.read();
			}
		}, "t2");
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				wr.write();
			}
		}, "t3");
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				wr.write();
			}
		}, "t4");
		
		//t1.start();
		//t2.start();
		t3.start();
		t4.start();
	}
}

