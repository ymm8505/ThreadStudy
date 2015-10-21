package com.xiaoyang.golf.ProCom;

public class T_Main {
	
	/*
	 ������������ģʽ˵����
	1.������ֻ�ڲֿ�δ��ʱ�����������ֿ���ʱ�����߽��̱�������
	2.������ֻ�ڲֿ�ǿ�ʱ�������ѣ��ֿ�Ϊ��ʱ�����߽��̱�������
	3.�������߷��ֲֿ�Ϊ��ʱ��֪ͨ������������
	4.�������߷��ֲֿ���ʱ��֪ͨ���������ѣ�
	
	��������������notify ��ΪnotifyAll �������������������
	*/

	public static void main(String[] args) {
		String lock =  new String("");
		T_Product p = new T_Product(lock);
		T_Customer c = new T_Customer(lock);
		
		ThreadP[] threadP = new ThreadP[2];
		ThreadC[] threadC = new ThreadC[2];
		
		for(int i=0;i<2;i++){
			threadP[i] = new ThreadP(p);
			threadP[i].setName("������"+(i+1));
			threadC[i] = new ThreadC(c);
			threadC[i].setName("������"+(i+1));
			
			threadP[i].start();
			threadC[i].start();
		}
	}

}

class ThreadP extends Thread{
	
	private T_Product  pp;
	public ThreadP(T_Product p) {
		super();
		pp = p;
	}
	
	@Override
	public void run() {
		while(true){
			pp.setValue();
		}
	}
}


class ThreadC extends Thread{
	private T_Customer  cc;
	public ThreadC(T_Customer c) {
		super();
		cc = c;
	}
	@Override
	public void run() {
		while(true){
			cc.getValue();
		}
	}
}