package com.xiaoyang.golf;

public class T_Product_BAK {
	
	/*
	 生产者消费者模式说明：
	1.生产者只在仓库未满时进行生产，仓库满时生产者进程被阻塞；
	2.消费者只在仓库非空时进行消费，仓库为空时消费者进程被阻塞；
	3.当消费者发现仓库为空时会通知生产者生产；
	4.当生产者发现仓库满时会通知消费者消费；
	*/
//	定义仓库的长度
	private final int store_length = 5;

	public static void main(String[] args) {
//		启动生产者线程 3个生产者
		new Thread(new Runnable() {
			public void run() {
//				调用生产者方法开始往仓库里面扔馒头
			}
		}).start();
		
//		启动消费者线程 2个消费者
		new Thread().start();
	}
	
	

}
