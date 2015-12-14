package com.xiaoyang.itcast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExxcutorsStudy {

	public static void main(String[] args) {

		// ExecutorService threadPool = Executors.newCachedThreadPool();
		// ExecutorService threadPool = Executors.newCachedThreadPool();

		ExecutorService threadFixPool = Executors.newFixedThreadPool(3);
		for ( int j = 1; j < 10; j++) {
			final int task = j; 
			threadFixPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 1; i <= 10; i++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "                  is looping of " + i + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");

		threadFixPool.shutdown();
	}

}
