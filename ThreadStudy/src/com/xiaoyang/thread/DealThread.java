package com.xiaoyang.thread;

public class DealThread implements Runnable {
	public String username;
	public Object lokc1 = new Object();
	public Object lokc2 = new Object();

	public void setNmae(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		if (username.equals("a")) {
			synchronized (lokc1) {
				System.out.println("username------->" + username);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lokc2) {
					System.out.println("按照  1ock1---------->locak2代码顺序执行了");
				}
			}
		}

		if (username.equals("b")) {
			synchronized (lokc2) {
				System.out.println("username------->" + username);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lokc1) {
					System.out.println("按照  1ock2---------->locak1代码顺序执行了");
				}
			}
		}
	}
}
