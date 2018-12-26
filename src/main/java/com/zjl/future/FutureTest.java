package com.zjl.future;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 下午3:27:39 
*/
public class FutureTest {

	public static void main(String[] args) {
		FutureClient client = new FutureClient();
		Data data = client.request("查询数据");
		System.out.println("做其他事情。。。");
		String result = data.getRequest();
		System.out.println(result);
		System.out.println("完成");
	}

}

