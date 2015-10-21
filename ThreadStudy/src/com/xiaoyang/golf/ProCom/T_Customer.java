package com.xiaoyang.golf.ProCom;

import java.util.concurrent.BlockingQueue;

public class T_Customer {
	/*
	 ������������ģʽ˵����
	2.������ֻ�ڲֿ�ǿ�ʱ�������ѣ��ֿ�Ϊ��ʱ�����߽��̱�������
	*/
	private String lock;
	
    

	public T_Customer(String lock) {
		super();
		this.lock = lock;
	}
	
	public void getValue(){
		try {
			synchronized (lock) {
				while(T_ValueObject.value.equals("")){
					System.out.println(Thread.currentThread().getName()+"������wait������");
					lock.wait();
				}
				System.out.println(Thread.currentThread().getName()+"������Running����");
				T_ValueObject.value = "";
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
