package com.xiaoyang.thread;

import java.util.Random;

/*
 * Threadlocal只能往里放一个Object对象多个线程用于自己的Threadlocal对象来存储
 * 
 * 延伸如果想放入多个Object对象该怎么办?
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
						+ " A 取到的Date为--------------->" + x.get());
			}
		}

		static class B {
			public void getDate() {
				System.out.println(Thread.currentThread().getName()
						+ " B 取到的Date为->" + x.get());
			}
		}
	}
