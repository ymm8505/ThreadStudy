package com.xiaoyang.itcast;

/*ģ����������Ʊ 4������ͬʱ������  ��100��Ʊ*/
public class ShareDate12306 {
	public static void main(String[] args) throws InterruptedException {
		ShearDate shearDate = new ShearDate();
//		����4���߳�
		Thread thread1 = new Thread(shearDate);
		thread1.setName("��ƱԱ1");
		thread1.start();
		Thread.sleep(1);
		Thread thread2 = new Thread(shearDate);
		thread2.setName("��ƱԱ2");
		thread2.start();
//		Thread thread3 = new Thread(shearDate);
//		thread3.setName("��ƱԱ3");
//		thread3.start();
//		Thread thread4 = new Thread(shearDate);
//		thread4.setName("��ƱԱ4");
//		thread4.start();
	}
	
	static class ShearDate implements Runnable{
		private  boolean TickerEn = true;
//		����Ʊ������
		private int TickerCount = 100;
		@Override
		public  void run() {
			while(TickerEn){
				System.out.println(Thread.currentThread().getName() +" ��Ʊ�ɹ��� ��Ʊ����Ϊ--->"+TickerCount);
				TickerCount--;
				if(TickerCount <1){
					TickerEn = false;
				}
			}
			
		}
	}

}
