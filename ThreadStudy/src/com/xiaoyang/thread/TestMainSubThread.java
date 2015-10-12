package com.xiaoyang.thread;

/*
 * 子线程循环10次，接着主线程循环100，
 * 接着又回到子线程循环10次，接着再回到主线程又循环100，
 * 如此循环50次，请写出程序。
 * 
 * */
public class TestMainSubThread {
	static boolean runflag = true;

	public static void main(String[] args) {

		class mianRunnable implements Runnable {
			@Override
			public void run() {
				if (runflag) {
					for (int i = 0; i < 100; i++) {
						System.out.println("【主】线程循环到" + (i + 1) + "次了");
					}
				} else {
					runflag = false;
				}
			}
		}

		class subRunnable implements Runnable {
			@Override
			public void run() {
				if (runflag) {
					for (int i = 0; i < 10; i++) {
						System.out.println("子线程循环到" + (i + 1) + "次了");
					}
				} else {
					runflag = false;
				}
			}
		}

		Thread mianThread = new Thread(new mianRunnable());
		Thread subThread = new Thread(new subRunnable());
		mianThread.start();
		subThread.start();
	}

}
