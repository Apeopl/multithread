package com.zjl.queue;
/** 
* 描述：DelayQueue延迟队列
* @author zhengjinlei 
* @version 2018年12月26日 下午2:19:18 
*/
public class DelayQueueTest {
	public static void main(String[] args) {
		WangBa wb = new WangBa();
		wb.setYingye(true);
		System.out.println("网吧开始营业");
		Thread wujixian = new Thread(wb);
		wujixian.start();
		wb.shangji(2, "bruce", 2);
		wb.shangji(3, "json", 8);
		wb.shangji(4, "jack", 4);
	}
}

