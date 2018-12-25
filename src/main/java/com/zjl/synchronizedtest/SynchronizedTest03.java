package com.zjl.synchronizedtest;
/** 
* 描述：脏读问题
* @author zhengjinlei 
* @version 2018年12月25日 上午9:45:04 
*/
public class SynchronizedTest03 {
	private String uname = "zjl";
	private String pwd = "123";
	
	public synchronized void setValue(String uname,String pwd){
		this.uname = uname;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.pwd = pwd;
		System.out.println("setValue: uname="+uname+",pwd="+pwd);
	}
	public /*synchronized*/ void getValue(){
		System.out.println("getValue: uname="+uname+",pwd="+pwd);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final SynchronizedTest03 st = new SynchronizedTest03();
		Thread t = new Thread(new Runnable() {
			public void run() {
				st.setValue("fxx", "456");
			}
		});
		t.start();
		Thread.sleep(1000);
		st.getValue();
	}
}

