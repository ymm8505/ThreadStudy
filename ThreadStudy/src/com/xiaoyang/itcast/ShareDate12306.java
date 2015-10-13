package com.xiaoyang.itcast;

/*模拟往出卖火车票 4个窗口同时往外卖  有100张票*/
public class ShareDate12306 {
	public static void main(String[] args) throws InterruptedException {
		ShearDate shearDate = new ShearDate();
//		启动4个线程
		Thread thread1 = new Thread(shearDate);
		thread1.setName("售票员1");
		thread1.start();
		Thread.sleep(1);
		Thread thread2 = new Thread(shearDate);
		thread2.setName("售票员2");
		thread2.start();
//		Thread thread3 = new Thread(shearDate);
//		thread3.setName("售票员3");
//		thread3.start();
//		Thread thread4 = new Thread(shearDate);
//		thread4.setName("售票员4");
//		thread4.start();
	}
	
	static class ShearDate implements Runnable{
		private  boolean TickerEn = true;
//		定义票的总数
		private int TickerCount = 100;
		@Override
		public  void run() {
			while(TickerEn){
				System.out.println(Thread.currentThread().getName() +" 出票成功。 车票代码为--->"+TickerCount);
				TickerCount--;
				if(TickerCount <1){
					TickerEn = false;
				}
			}
			
		}
	}

}
