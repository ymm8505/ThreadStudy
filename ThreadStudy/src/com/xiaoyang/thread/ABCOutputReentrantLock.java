package com.xiaoyang.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * 三个线程依次输出 10次
 * 方法一：JDK   1.4方案 启动3个线程  A、B、C 再来一个ReentrantLock
 *  三个线程依次启动,获得lock对象的线程完成输出然后改变判断条件。三个线程再次开始争抢资源
 *  
 *  
 * */

public class ABCOutputReentrantLock {
	static Lock lock = new ReentrantLock();
	static int count = 0;

	static class MyThreadA extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 10;) {
//				System.out.println("有不需要的输出---MyThreadA---------"+i);
					lock.lock();
					while (count % 3 == 0) {
						// 走到这里说明 能被3整除 0 3 6
						System.out.println("正常输出------------------>A" + count);
						count++;
						i++;
					}
					lock.unlock();
			}
		}
	}

	static class MyThreadB extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 10; ) {
//				System.out.println("有不需要的输出---MyThreadB---------"+i);
					lock.lock();
					while (count % 3 == 1) {
						// 走到这里说明 能被3整除 0 3 6
						System.out.println("正常输出------------------>B" + count);
						count++;
						i++;
					}
					lock.unlock();
				}
			}
		}

	static class MyThreadC extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 10;) {
//				System.out.println("有不需要的输出---MyThreadC---------"+i);
					lock.lock();
					while (count % 3 == 2) {
						// 走到这里说明 能被3整除 0 3 6
						System.out.println("正常输出------------------>C" + count);
						count++;
						i++;
					}
					lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new MyThreadA().start();
        new MyThreadB().start();
        new MyThreadC().start();
	}

}
