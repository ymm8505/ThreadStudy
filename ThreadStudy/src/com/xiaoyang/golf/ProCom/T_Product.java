package com.xiaoyang.golf.ProCom;

public class T_Product {
	
	/*
	 ������������ģʽ˵����
	1.������ֻ�ڲֿ�δ��ʱ�����������ֿ���ʱ�����߽��̱�������
	*/
	private String lock;

	public T_Product(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue(){
		try {
			synchronized (lock) {
				while (!T_ValueObject.value.equals("")) {
					System.out.println(Thread.currentThread().getName()+ "--->������--->Wait�� ");

					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println(Thread.currentThread().getName()+ "--->������--->Running���� "+value);
				T_ValueObject.value = value;
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
