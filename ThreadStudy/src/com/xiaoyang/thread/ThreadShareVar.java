package com.xiaoyang.thread;


/*多线程操作共享变量。
 * 方案一：【 操作对象在内部类里面，共线对象放到 外部类。】
 * 
 * 方案二：将共享数据封装在另一个对象中，然后将这个对象逐一传递给每个运行的Runnable对象。每个线程
 * 【对共享数据的操作方法也分配到传入的共享对象身上去完成】。
 * 这样容易实现对给数据进行的各个操作的互斥和通讯。
 * 例如本例子
 * 
 * */

public class ThreadShareVar {
	public static void main(String[] args) throws InterruptedException {
		ShareDate shareDate = new ShareDate();
		new Thread(new MyRunnableIncre(shareDate)).start();
		new Thread(new MyRunnableIncre(shareDate)).start();
		new Thread(new MyRunnableDecre(shareDate)).start();
		new Thread(new MyRunnableDecre(shareDate)).start();

		/*
		 * 最笨的办法一
		 * for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					System.out.println(Thread.currentThread().getName()
							+ "对   i  加一操作---前值为---------->"+atdate.get()+"  后值为---->" + atdate.incrementAndGet());
				}
			}).start();
		}
		for (int i = 0; i < 8; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()
							+ "对   i  减一操作---前值为"+atdate.get()+"  后值为---->" + atdate.decrementAndGet());
				}
			}).start();
		}*/
	}
}
	
	//共享对象 把操作动作放在共享对象身上
	class ShareDate {
		private int j = 0;
		public synchronized void increment() {
			j++;
			System.out.println( Thread.currentThread().getName()+"加法---------->"+j);
		}

		public synchronized void decrement() {
			j--;
			System.out.println(Thread.currentThread().getName()+ "减法---------->"+j);
		}
	}
	
	//两个Runnable 类在这个类里面 接受共享变量
	class MyRunnableIncre implements Runnable{
		ShareDate shareDateA;
		
		public MyRunnableIncre(ShareDate shareDate1) {
			this.shareDateA = shareDate1;
		}

		@Override
		public void run() {
			shareDateA.increment();
		}
	}
	
	class MyRunnableDecre implements Runnable{
		ShareDate shareDateB;
		
		public MyRunnableDecre(ShareDate shareDate1) {
			this.shareDateB = shareDate1;
		}

		@Override
		public void run() {
			shareDateB.decrement();
		}
	}

