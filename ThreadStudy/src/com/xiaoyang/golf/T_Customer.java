package com.xiaoyang.golf;

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
				if(T_ValueObject.value.equals("")){
					System.out.println("�����߿�ʼ����----1>����ûֵ�ȴ��С���");
					lock.wait();
				}
				System.out.println("�����߿�ʼ����----2>����get��valueֵ��"+T_ValueObject.value);
				T_ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
