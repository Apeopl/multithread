package com.zjl.masterworker;

import java.util.Random;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 下午5:01:37 
*/
public class MasterWokerTest {
	public static void main(String[] args) {
		Master master = new Master(new Worker(), 50);
		Random random = new Random();
		for(int i=0; i<100; i++){
			Task task = new Task();
			task.setId(i);
			task.setName("节点"+i);
			task.setPrice(random.nextInt(100));
			master.submit(task);
		}
		master.execute();
		long start = System.currentTimeMillis();
		while(true){
			if(master.isComplete()){
				int result = master.getResult();
				long time = System.currentTimeMillis() - start;
				System.out.println("结果是："+result+",耗时："+time);
				break;
			}
		}
	}
}

