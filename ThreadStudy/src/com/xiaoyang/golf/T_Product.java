package com.xiaoyang.golf;

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
				if(!T_ValueObject.value.equals("")){
					System.out.println("������ ��ʼ����----2>������ֵ  �ȴ�getȡ��");
						lock.wait();
				}
				String value = System.currentTimeMillis()+"_"+System.nanoTime();
				System.out.println("������ ��ʼ����----1>value ����set��ֵ��"+value);
				T_ValueObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
