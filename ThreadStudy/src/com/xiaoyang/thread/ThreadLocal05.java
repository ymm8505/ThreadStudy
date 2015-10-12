package com.xiaoyang.thread;

import java.util.Random;

public class ThreadLocal05 {
	private static int date = 0;

	public static void main(String[] args) throws InterruptedException {
//		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					date = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ "    put Date    " + date);
					new A().getDate();
					new B().getDate();
				}
			}).start();
//		}
	}

		static class A {
			public void getDate() {
				System.out.println(Thread.currentThread().getName()
						+ " A 取到的Date为--->" + date);
			}
		}

		static class B {
			public void getDate() {
				System.out.println(Thread.currentThread().getName()
						+ " B 取到的Date为->" + date);
			}
		}
	}
