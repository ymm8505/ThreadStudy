package com.xiaoyang.thread;


/*
四个线程 两个线程 对共享变量+1操作。
                  两个线程对共享变量-1操作
                  
第一步写出两个线程对象 处理同一个数据对象。

内部类操作外部类的共享变量。直接操作没法控制同步互斥，在外部类中把对共享变量的操作，放到方法中，
这样可以用synchronized 来控制对共享变量的访问。
内部类是一个Runnable类。
                  

多个 synchronized 方法之间互斥。
只能调用多个synchronized方法中的其中一个。这样increment 和decrement 方法互斥。
在同一个synchronized方法中，多个线程来只能有一个线程进来执行。保持额同步。
                  
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