package com.xiaoyang.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * 两个线程依次输出zhangxiaoxiang     lihuoming
 * Lock rlock = new ReentrantLock();
 * 或者
 * synchronized 
 * */

public class OutputTwoStr {

	final static Outputer outputer = new Outputer();
	public static void main(String[] args) throws InterruptedException {
		MyThreadAA a = new MyThreadAA();
		MyThreadBB b = new MyThreadBB();
			b.start();
			a.start();
	}

	static class Outputer {
		Lock rlock = new ReentrantLock();
		private  void output1(String name) {
			rlock.lock();
			try {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println("");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				rlock.unlock();
			}			
			
		}

		private void output2(String name) {
			rlock.lock();
			try {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println("");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				rlock.unlock();
			}	
		}
	}

	static class MyThreadAA extends Thread {
		@Override
		public  void run() {
			while (true) {
				try {
					outputer.output1("yangnn");
					Thread.sleep(20);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class MyThreadBB extends Thread {
		@Override
		public  void run() {
			// lock.lock();
			while (true) {
				try {
					outputer.output2("menghh");
					Thread.sleep(20);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// finally{
			// lock.unlock();
			// }
		}
	}
}
