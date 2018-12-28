package com.zjl.future;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 下午3:24:39 
*/
public class FutureClient {
	public Data request(final String queryStr){
		final FutureData futureData = new FutureData();
		new Thread(new Runnable() {
			public void run() {
				RealData data = new RealData(queryStr);
				futureData.setRealData(data);
			}
		}).start();
		return futureData;
	}
}

