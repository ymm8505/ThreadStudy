package com.xiaoyang.golf.ProCom;

import java.util.concurrent.BlockingQueue;

public class T_Customer {
	/*
	 生产者消费者模式说明：
	2.消费者只在仓库非空时进行消费，仓库为空时消费者进程被阻塞；
	*/
	private String lock;
	
    

	public T_Customer(String lock) {
		super();
		this.lock = lock;
	}
	
	public void getValue(){
		try {
			synchronized (lock) {
				while(T_ValueObject.value.equals("")){
					System.out.println(Thread.currentThread().getName()+"消费者wait……☆");
					lock.wait();
				}
				System.out.println(Thread.currentThread().getName()+"消费者Running……");
				T_ValueObject.value = "";
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
