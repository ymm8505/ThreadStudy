package com.xiaoyang.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * �����߳�������� 10��
 * ����һ��JDK   1.4���� ����3���߳�  A��B��C ����һ��ReentrantLock
 *  �����߳���������,���lock������߳�������Ȼ��ı��ж������������߳��ٴο�ʼ������Դ
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
//				System.out.println("�в���Ҫ�����---MyThreadA---------"+i);
					lock.lock();
					while (count % 3 == 0) {
						// �ߵ�����˵�� �ܱ�3���� 0 3 6
						System.out.println("�������------------------>A" + count);
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
//				System.out.println("�в���Ҫ�����---MyThreadB---------"+i);
					lock.lock();
					while (count % 3 == 1) {
						// �ߵ�����˵�� �ܱ�3���� 0 3 6
						System.out.println("�������------------------>B" + count);
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
//				System.out.println("�в���Ҫ�����---MyThreadC---------"+i);
					lock.lock();
					while (count % 3 == 2) {
						// �ߵ�����˵�� �ܱ�3���� 0 3 6
						System.out.println("�������------------------>C" + count);
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
