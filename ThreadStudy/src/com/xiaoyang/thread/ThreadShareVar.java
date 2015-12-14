package com.xiaoyang.thread;


/*���̲߳������������
 * ����һ���� �����������ڲ������棬���߶���ŵ� �ⲿ�ࡣ��
 * 
 * �����������������ݷ�װ����һ�������У�Ȼ�����������һ���ݸ�ÿ�����е�Runnable����ÿ���߳�
 * ���Թ������ݵĲ�������Ҳ���䵽����Ĺ����������ȥ��ɡ���
 * ��������ʵ�ֶԸ����ݽ��еĸ��������Ļ����ͨѶ��
 * ���籾����
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
		 * ��İ취һ
		 * for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					System.out.println(Thread.currentThread().getName()
							+ "��   i  ��һ����---ǰֵΪ---------->"+atdate.get()+"  ��ֵΪ---->" + atdate.incrementAndGet());
				}
			}).start();
		}
		for (int i = 0; i < 8; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()
							+ "��   i  ��һ����---ǰֵΪ"+atdate.get()+"  ��ֵΪ---->" + atdate.decrementAndGet());
				}
			}).start();
		}*/
	}
}
	
	//������� �Ѳ����������ڹ����������
	class ShareDate {
		private int j = 0;
		public synchronized void increment() {
			j++;
			System.out.println( Thread.currentThread().getName()+"�ӷ�---------->"+j);
		}

		public synchronized void decrement() {
			j--;
			System.out.println(Thread.currentThread().getName()+ "����---------->"+j);
		}
	}
	
	//����Runnable ������������� ���ܹ������
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

