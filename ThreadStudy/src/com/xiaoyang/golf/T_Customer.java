package com.xiaoyang.golf;

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
				if(T_ValueObject.value.equals("")){
					System.out.println("消费者开始工作----1>现在没值等待中……");
					lock.wait();
				}
				System.out.println("消费者开始工作----2>本次get的value值是"+T_ValueObject.value);
				T_ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
