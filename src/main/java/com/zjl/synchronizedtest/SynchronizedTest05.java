package com.zjl.synchronizedtest;
/** 
* 描述：字符串常量作为锁出现的异常
* @author zhengjinlei 
* @version 2018年12月25日 下午2:06:54 
*/
public class SynchronizedTest05 {
	/**
	 * 当锁为字符串常量时，引用只有一个
	 */
	public void method(){
		synchronized ("字符串常量") {//new String("字符串常量")
			try {
				while(true){
					System.out.println("当前线程："+Thread.currentThread().getName()+"开始！");
					Thread.sleep(1000);
					System.out.println("当前线程："+Thread.currentThread().getName()+"结束！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		final SynchronizedTest05 st = new SynchronizedTest05();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				st.method();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				st.method();
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}

