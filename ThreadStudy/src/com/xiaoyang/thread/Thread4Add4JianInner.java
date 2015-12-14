package com.xiaoyang.thread;


/*
�ĸ��߳� �����߳� �Թ������+1������
                  �����̶߳Թ������-1����
                  
��һ��д�������̶߳��� ����ͬһ�����ݶ���

�ڲ�������ⲿ��Ĺ��������ֱ�Ӳ���û������ͬ�����⣬���ⲿ���аѶԹ�������Ĳ������ŵ������У�
����������synchronized �����ƶԹ�������ķ��ʡ�
�ڲ�����һ��Runnable�ࡣ
                  

��� synchronized ����֮�以�⡣
ֻ�ܵ��ö��synchronized�����е�����һ��������increment ��decrement �������⡣
��ͬһ��synchronized�����У�����߳���ֻ����һ���߳̽���ִ�С����ֶ�ͬ����
                  
                  */
public class Thread4Add4JianInner {
	static int i = 0;
	
	public static void main(String[] args) {
		Thread4Add4JianInner addJian = new Thread4Add4JianInner();
		Increment incR = addJian.new Increment();
		Decrement dec = addJian.new Decrement();
		
		for(int i = 0; i< 2;i++){
		Thread t = new Thread(incR);
		Thread t1 = new Thread(dec);
		t.start();
		t1.start();
		}
		
	}
	
	private synchronized void incr(){
		i++;
		System.out.println("+++++++++++++++++"+i);
	};
	private synchronized void decr(){
		i--;
		System.out.println("-----------------"+i);
	};
	
	
	
	class Increment implements Runnable{
		@Override
		public void run() {
			incr();
		}
	}
	
	class Decrement implements Runnable{
		@Override
		public void run() {
			decr();
		}
	}

}