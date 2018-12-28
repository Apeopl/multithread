package com.zjl.synchronizedtest;
/** 
* 描述：多个对象一把锁，多个对象多把锁
* @author zhengjinlei 
* @version 2018年12月25日 上午9:45:04 
*/
public class SynchronizedTest01 {
	private static int num = 0;
	/**
	 * 当方法上加上static时，会变成静态方法，此时synchronized会用到类锁（多个对象一把锁）
	 * 当方法是普通方法时，synchronized会用到对象锁（多个对象多把锁）
	 * @param nba
	 */
	public static synchronized void printNum(String nba){
			try {
				if("hadeng".equals(nba)){
					num = 100;
					System.out.println("火箭队!");
					Thread.sleep(1000);
				}else{
					num = 200;
					System.out.println("勇士队!");
				}
				System.out.println("NBA="+nba+",num="+num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		final SynchronizedTest01 s1 = new SynchronizedTest01();
		final SynchronizedTest01 s2 = new SynchronizedTest01();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				s1.printNum("hadeng");
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				s2.printNum("kuli");
			}
		});
		t1.start();
		t2.start();
	}
}

