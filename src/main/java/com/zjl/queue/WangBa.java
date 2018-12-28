package com.zjl.queue;

import java.util.concurrent.DelayQueue;

/** 
* 描述：网吧
* @author zhengjinlei 
* @version 2018年12月26日 下午2:13:03 
*/
public class WangBa implements Runnable{
	private DelayQueue<WangMin> queue = new DelayQueue<WangMin>();
	public boolean yingye;
	
	public void shangji(int id, String name, int money){
		WangMin wm = new WangMin(id, name, money*1000+System.currentTimeMillis());
		this.queue.add(wm);
		System.out.println("网民"+name+"开始上网。。。");
	}
	
	public void xiaji(WangMin wm){
		System.out.println("网民"+wm.getName()+"下机了。。。");
	}

	public void run() {
		while(yingye){
			try {
				WangMin wm = queue.take();
				xiaji(wm);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isYingye() {
		return yingye;
	}

	public void setYingye(boolean yingye) {
		this.yingye = yingye;
	}
	
}

