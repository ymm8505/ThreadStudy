package com.xiaoyang.thread;

import java.util.concurrent.Semaphore;

/*
 * 
 * �����߳�������� 10��
 * ����һ��JDK   1.4���� ����3���߳�  A��B��C �Լ���������޸��жϽ����ֳ���ֵΪ��һ����
 *  ��A�������Flag�޸�ΪB Ȼ��notifyAll().  ��������Լ�������this.wait()
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


