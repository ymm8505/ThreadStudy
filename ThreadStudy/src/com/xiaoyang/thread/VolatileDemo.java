package com.xiaoyang.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {

	private Lock lock = new ReentrantLock();
	private int number = 0;

	public int getNumber() {
		return this.number;
	}

	public void increase() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*����һ
		 * synchronized (this) {
			this.number++;
		}*/
		
		lock.lock();
		try {
			this.number++;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final VolatileDemo volDemo = new VolatileDemo();
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					volDemo.increase();
				}
			}).start();
		}

		// ����������߳������У����߳̾��ó�CPU��Դ��
		// ֱ�����е����̶߳��������ˣ����߳��ټ�������ִ��
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}

		System.out.println("number : " + volDemo.getNumber());
	}

}
