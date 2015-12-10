package com.xiaoyang.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
 * 
 * 三个线程依次输出 10次
 * 方法一：JDK   1.4方案 启动3个线程  A、B、C 再来三个Condition
 *  如A运行完把Flag修改为B 然后Condition.signal()  如果不该自己运行则Condition.await()
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
//				走到这里说明 能被3整除 0 3 6
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
//				走到这里说明 能被3整除 0 3 6
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
//				走到这里说明 能被3整除 0 3 6
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


