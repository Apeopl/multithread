package com.zjl.masterworker;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年12月26日 下午4:46:43 
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//装任务的队列
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
	//HashMap承装所有的worker对象
	private HashMap<String, Thread> workers = new HashMap<String, Thread>();
	//结果集
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
	
	//构造方法
	public Master(Worker worker, int workerCount){
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for(int i=0; i<workerCount; i++){
			workers.put("节点"+i, new Thread(worker));
		}
	}
	
	//提交
	public void submit(Task task){
		this.workQueue.add(task);
	}
	//执行
	public void execute(){
		for(Map.Entry<String, Thread> me:workers.entrySet()){
			me.getValue().start();
		}
	}

	public boolean isComplete() {
		for(Map.Entry<String, Thread> me:workers.entrySet()){
			if(me.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}

	public int getResult() {
		int result = 0;
		for(Map.Entry<String, Object> me:resultMap.entrySet()){
			result += (Integer)me.getValue();
		}
		return result;
	}
}

