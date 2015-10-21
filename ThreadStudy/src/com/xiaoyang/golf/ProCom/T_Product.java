package com.xiaoyang.golf.ProCom;

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
				while (!T_ValueObject.value.equals("")) {
					System.out.println(Thread.currentThread().getName()+ "--->生产者--->Wait★ ");

					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println(Thread.currentThread().getName()+ "--->生产者--->Running…… "+value);
				T_ValueObject.value = value;
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
