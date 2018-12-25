package com.zjl.synchronizedtest;
/** 
* 描述：异常
* @author zhengjinlei 
* @version 2018年12月25日 上午11:25:54 
*/
public class SynchronizedException {
	private static int num = 0;
	public synchronized void op(){
		while(true){
			try {
				num++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName()+",num="+num);
				if(num == 10){
					Integer.parseInt("a");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("log info num="+num);
				//throw new RuntimeException();
				continue;
			}
		}
	}
	public static void main(String[] args) {
		final SynchronizedException se = new SynchronizedException();
		new Thread(new Runnable() {
			public void run() {
				se.op();
			}
		}, "t1").start();
	}
}

