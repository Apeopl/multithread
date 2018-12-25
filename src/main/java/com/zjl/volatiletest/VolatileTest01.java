package com.zjl.volatiletest;
/** 
* 描述：变量可见性
* @author zhengjinlei 
* @version 2018年12月25日 下午2:42:11 
*/
public class VolatileTest01 extends Thread{
	private volatile boolean isRunning = true;
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	@Override
	public void run() {
		System.out.println("进入run方法。。。");
		while(isRunning == true){
			//System.out.println("running");
		}
		System.out.println("线程停止。。。");
	}
	public static void main(String[] args) throws InterruptedException {
		VolatileTest01 vt = new VolatileTest01();
		vt.start();
		Thread.sleep(3000);
		vt.setRunning(false);
		System.out.println("设置完成。。。");
		Thread.sleep(1000);
		System.out.println(vt.isRunning);
	}
}

