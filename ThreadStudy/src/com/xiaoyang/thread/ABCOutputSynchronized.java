package com.xiaoyang.thread;

/*
 * 
 * 三个线程依次输出 10次
 * 方法一：JDK   1.4方案 启动3个线程  A、B、C 自己运行完毕修改判断进入现场的值为下一个。
 *  如A运行完把Flag修改为B 然后notifyAll().  如果不该自己运行则this.wait()
 *  
 *  
 * */

public class ABCOutputSynchronized {
		public static void main(String[] args) throws InterruptedException {
		final Buesss buess =  new Buesss();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						buess.Main(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						buess.Sub(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						buess.Sub3(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	
		
	}
}
class Buesss{
	private String Flag = "A";
	public synchronized void Main(int m) throws InterruptedException{
		while(!"A".equals(Flag)){
			System.out.println("非法入侵…………………………………………………………………………");
			this.wait();
		}
		System.out.println(Flag +"----------->"+m);
		Flag = "B";
		this.notifyAll();
	}

	public synchronized void Sub(int m) throws InterruptedException{
		while(!"B".equals(Flag)){
			System.out.println("非法入侵………………………………………………………………………………………………………………");
			this.wait();
		}
		System.out.println(Flag +"----------->"+m);
		Flag = "C";
		this.notifyAll();
	}

	public synchronized void Sub3(int m) throws InterruptedException{
		while(!"C".equals(Flag)){
			System.out.println("非法入侵………………………………………………………………………………………………………………………………………………………………");
			this.wait();
		}
		System.out.println(Flag +"----------->"+m);
		Flag = "A";
		this.notifyAll();
	}
}
