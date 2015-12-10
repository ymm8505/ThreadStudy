package com.xiaoyang.thread;

/*
 * 
 * �����߳�������� 10��
 * ����һ��JDK   1.4���� ����3���߳�  A��B��C �Լ���������޸��жϽ����ֳ���ֵΪ��һ����
 *  ��A�������Flag�޸�ΪB Ȼ��notifyAll().  ��������Լ�������this.wait()
 *  
 *  
 * */

public class ABCOutputSynchronized {
		public static void main(String[] args) throws InterruptedException {
		final Buesss buess =  new Buesss();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						buess.Main(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						buess.Sub(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 10;i++){
					try {
						buess.Sub3(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	
		
	}
}
class Buesss{
	private String Flag = "A";
	public synchronized void Main(int m) throws InterruptedException{
		while(!"A".equals(Flag)){
			System.out.println("�Ƿ����֡�������������������������������������������������������");
			this.wait();
		}
		System.out.println(Flag +"----------->"+m);
		Flag = "B";
		this.notifyAll();
	}

	public synchronized void Sub(int m) throws InterruptedException{
		while(!"B".equals(Flag)){
			System.out.println("�Ƿ����֡�����������������������������������������������������������������������������������");
			this.wait();
		}
		System.out.println(Flag +"----------->"+m);
		Flag = "C";
		this.notifyAll();
	}

	public synchronized void Sub3(int m) throws InterruptedException{
		while(!"C".equals(Flag)){
			System.out.println("�Ƿ����֡�����������������������������������������������������������������������������������������������������������������������");
			this.wait();
		}
		System.out.println(Flag +"----------->"+m);
		Flag = "A";
		this.notifyAll();
	}
}
