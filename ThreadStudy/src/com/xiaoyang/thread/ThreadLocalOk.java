package com.xiaoyang.thread;

import java.util.Random;

/*
 * Threadlocalֻ�������һ��Object�������߳������Լ���Threadlocal�������洢
 * 
 * ��������������Object�������ô��?
*/
public class ThreadLocalOk {
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>(); 

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int date = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ "    put Date    " + date);
					x.set(date);
					new A().getDate();
					new B().getDate();
				}
			}).start();
		}
	}

		static class A {
			public void getDate() {
				System.out.println(Thread.currentThread().getName()
						+ " A ȡ����DateΪ--------------->" + x.get());
			}
		}

		static class B {
			public void getDate() {
				System.out.println(Thread.currentThread().getName()
						+ " B ȡ����DateΪ->" + x.get());
			}
		}
	}
