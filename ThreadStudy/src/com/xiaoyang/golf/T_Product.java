package com.xiaoyang.golf;

public class T_Product {
	
	/*
	 生产者消费者模式说明：
	1.生产者只在仓库未满时进行生产，仓库满时生产者进程被阻塞；
	*/
	private String lock;

	public T_Product(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue(){
		try {
			synchronized (lock) {
				if(!T_ValueObject.value.equals("")){
					System.out.println("生产者 开始工作----2>现在有值  等待get取走");
						lock.wait();
				}
				String value = System.currentTimeMillis()+"_"+System.nanoTime();
				System.out.println("生产者 开始工作----1>value 本次set的值是"+value);
				T_ValueObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
