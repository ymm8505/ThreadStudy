package com.xiaoyang.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
 * 
 * �����߳�������� 10��
 * ����һ��JDK   1.4���� ����3���߳�  A��B��C ��������Condition
 *  ��A�������Flag�޸�ΪB Ȼ��Condition.signal()  ��������Լ�������Condition.await()
 *  
 *  
 * */

public class ABCOutputCondation {
	static Lock lock = new ReentrantLock();
	static Condition ConditionA =  lock.newCondition();
	static Condition ConditionB =  lock.newCondition();
	static Condition ConditionC =  lock.newCondition();
	static int count = 0;
	
	static class MyThreadA extends Thread{
		@Override
		public void run() {
			lock.lock();
			try {
				for(int i = 1;i<= 10;i++){
					while(count%3 != 0){
							ConditionA.await();
					}
//				�ߵ�����˵�� �ܱ�3���� 0 3 6
					System.out.println("A" + count);
					count++;
					ConditionB.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	
	
	static class MyThreadB extends Thread{
		@Override
		public void run() {
			lock.lock();
			try {
				for(int i = 1;i<= 10;i++){
					while(count%3 != 1){
							ConditionB.await();
					}
//				�ߵ�����˵�� �ܱ�3���� 0 3 6
					System.out.println("B" + count);
					count++;
					ConditionC.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	
	
	static class MyThreadC extends Thread{
		@Override
		public void run() {
			lock.lock();
			try {
				for(int i = 1;i<= 10;i++){
					while(count%3 != 2){
							ConditionC.await();
					}
//				�ߵ�����˵�� �ܱ�3���� 0 3 6
					System.out.println("C" + count);
					count++;
					ConditionA.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	
		public static void main(String[] args) throws InterruptedException {
			MyThreadA a = new MyThreadA();
			MyThreadB b = new MyThreadB();
			MyThreadC c = new MyThreadC();
			b.start();
			c.start();
			a.start();
		}
		
}


