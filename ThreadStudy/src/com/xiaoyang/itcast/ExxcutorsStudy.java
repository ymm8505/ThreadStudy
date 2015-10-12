package com.xiaoyang.itcast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExxcutorsStudy {

	public static void main(String[] args) {

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName()
							+ " 正在执行第"+i+"次循环" +i);
				}
			}
		});
	}

}
