package com.xiaoyang.thread;

public class DeathThread {

	public static void main(String[] args) {
		DealThread t1 = new DealThread();
		t1.setNmae("a");
		Thread thread1 = new Thread(t1);
		thread1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
