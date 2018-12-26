package com.zjl.future;
/** 
* 描述：真实数据的请求
* @author zhengjinlei 
* @version 2018年12月26日 下午3:18:35 
*/
public class RealData implements Data {
	private String result;
	public RealData(String queryStr){
		System.out.println("开始查询。。。");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("操作完毕。。。");
		result = "结果数据";
	}
	
	public String getRequest() {
		return result;
	}

}

