package com.xiaoyang.golf;

public class TestSingleton {

	public static void main(String[] args) {
		
		for(int i = 1 ;i <3;i++)
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"----------->"+Singleton.getInstance());
			}
		}).start();

		for(int i = 1 ;i <3;i++)
			new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName()+"----------->"+Singleton.getInstance());
				}
			}).start();
	}

}
