package com.xiaoyang.itcast;



public class Thread4Add4Jian {

//	4个线程 2个线程对i 进行+1 操作   另外两个线程对i进行-1操作
	/*分析一下
	 * 两个对i 加1操作的线程需要互斥，我加的时候你不能加否则会出现计数不对 
	 * 同理  两个对i 减1操作的线程需要互斥，我减的时候你不能加否则会出现计数不对
	 * 另外 加和减 之间的总体上也需要互斥，我在做加的时候你也不能做减法。
	 * 
	 * */
	public static void main(String[] args) throws InterruptedException {
		final ShareDate myDate = new ShareDate();
		
		new Thread(new MyRunnableAdd(myDate)).start();
		new Thread(new MyRunnableAdd(myDate)).start();
		new Thread(new MyRunnableDec(myDate)).start();
		new Thread(new MyRunnableDec(myDate)).start();
		///////////////////////////////////////////////////////////////
			/*new Thread(new Runnable() {
				@Override
				public void run() {
					myDate.decrement();
				}
			}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				myDate.increment();
			}
		}).start();*/
		///////////////////////////////////////////////////////////////
		
	}
	
	static  class MyRunnableAdd implements Runnable{
		private ShareDate Date;
		public MyRunnableAdd(ShareDate Date1) {	
			this.Date = Date1;
		}
		public void run() {
//			i = i+1;
//			Thread.currentThread().setName("--->"+(++i));
			Date.increment();
		}
	 }
	 
	static class MyRunnableDec implements Runnable{
			private ShareDate Date;
			public MyRunnableDec(ShareDate Date1) {	
				this.Date = Date1;
			}
			public void run() {
//				Thread.currentThread().setName("<---");
				Date.decrement();
			}
		}
	 
	 
	
	static class ShareDate {
		private int  j = 10;
		public synchronized void increment(){
			j++;
			System.out.println(Thread.currentThread().getName()+ "  m:加1之后m:"+j +"   "+ +System.currentTimeMillis());
		}
		
		public synchronized void decrement(){
			j--;
			System.out.println(Thread.currentThread().getName()+ "  m:减1之后m:"+j +"   "+System.currentTimeMillis());
		}
	}
}
