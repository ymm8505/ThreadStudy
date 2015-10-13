package com.xiaoyang.itcast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ThreadLocal {

//	创建一个静态变量，在主线程里面设置随机数，然后再子线程里面获取。
	private static int date = 0;
	private static Map<Thread, Integer> threadMap = new HashMap<Thread, Integer>();
	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 0;i<2;i++){
				new Thread(new Runnable() {
					@Override
					public void run() {
						Integer date = new Random().nextInt();
						threadMap.put(Thread.currentThread(),date);
						System.out.println("线程名"+Thread.currentThread().getName()+"设置date的值为"+date);
						new A().getDate();
						new B().getDate();
					}
				}).start();
		}
	}
	
	static class A{
		public void getDate(){
			;
			System.out.println("A "+Thread.currentThread().getName()+"【获取 】date的值为"+threadMap.get(Thread.currentThread()));
		}
	}

	static class B{
		public void getDate(){
			System.out.println("B "+Thread.currentThread().getName()+"【获取 】date的值为"+threadMap.get(Thread.currentThread()));
		}
	}
}
