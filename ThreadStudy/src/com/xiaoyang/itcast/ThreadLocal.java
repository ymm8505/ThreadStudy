package com.xiaoyang.itcast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ThreadLocal {

//	����һ����̬�����������߳����������������Ȼ�������߳������ȡ��
	private static int date = 0;
	private static Map<Thread, Integer> threadMap = new HashMap<Thread, Integer>();
	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 0;i<2;i++){
				new Thread(new Runnable() {
					@Override
					public void run() {
						Integer date = new Random().nextInt();
						threadMap.put(Thread.currentThread(),date);
						System.out.println("�߳���"+Thread.currentThread().getName()+"����date��ֵΪ"+date);
						new A().getDate();
						new B().getDate();
					}
				}).start();
		}
	}
	
	static class A{
		public void getDate(){
			;
			System.out.println("A "+Thread.currentThread().getName()+"����ȡ ��date��ֵΪ"+threadMap.get(Thread.currentThread()));
		}
	}

	static class B{
		public void getDate(){
			System.out.println("B "+Thread.currentThread().getName()+"����ȡ ��date��ֵΪ"+threadMap.get(Thread.currentThread()));
		}
	}
}
