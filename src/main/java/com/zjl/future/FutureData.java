package com.zjl.future;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 下午3:20:56 
*/
public class FutureData implements Data {
	private RealData realData;
	private boolean isReady = false;

	public synchronized void setRealData(RealData realData){
		if(isReady){
			return;
		}
		this.realData = realData;
		isReady = true;
		notify();
	}
	
	public synchronized String getRequest() {
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.realData.getRequest();
	}

}

