package com.xiaoyang.thread;

import java.util.concurrent.Semaphore;

/*
 * 
 * 三个线程依次输出 10次
 * 方法一：JDK   1.4方案 启动3个线程  A、B、C 自己运行完毕修改判断进入现场的值为下一个。
 *  如A运行完把Flag修改为B 然后notifyAll().  如果不该自己运行则this.wait()
 *  
 *  
 * */

public class ABCOutputSemaphore {
		public static void main(String[] args) throws InterruptedException {
		final Semaphore semaphoreA = new Semaphore(1);
		final Semaphore semaphoreB = new Semaphore(1);
		final Semaphore semaphoreC = new Semaphore(1);
		
		semaphoreB.acquire();
		semaphoreC.acquire();
		
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						semaphoreA.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("A");
					semaphoreB.release();
				}
			}
		});
		
		
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						semaphoreB.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("B");
					semaphoreC.release();
				}
			}
		});
		
		
		Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						semaphoreC.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("C");
					semaphoreA.release();
				}
			}
		});
		
		threadA.start();
		threadB.start();
		threadC.start();
		}
}


