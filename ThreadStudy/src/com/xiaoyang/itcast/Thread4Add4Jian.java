package com.xiaoyang.itcast;



public class Thread4Add4Jian {

//	4���߳� 2���̶߳�i ����+1 ����   ���������̶߳�i����-1����
	/*����һ��
	 * ������i ��1�������߳���Ҫ���⣬�Ҽӵ�ʱ���㲻�ܼӷ������ּ������� 
	 * ͬ��  ������i ��1�������߳���Ҫ���⣬�Ҽ���ʱ���㲻�ܼӷ������ּ�������
	 * ���� �Ӻͼ� ֮���������Ҳ��Ҫ���⣬�������ӵ�ʱ����Ҳ������������
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
			System.out.println(Thread.currentThread().getName()+ "  m:��1֮��m:"+j +"   "+ +System.currentTimeMillis());
		}
		
		public synchronized void decrement(){
			j--;
			System.out.println(Thread.currentThread().getName()+ "  m:��1֮��m:"+j +"   "+System.currentTimeMillis());
		}
	}
}
