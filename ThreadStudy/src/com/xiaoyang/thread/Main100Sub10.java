package com.xiaoyang.thread;

/*
 * ���߳�ѭ��10�Σ��������߳�ѭ��100��
 * �����ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��100��
 * ���ѭ��50�Σ���д������
 * 
 * */
public class Main100Sub10 {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++){ 	//�ܹ�ѭ��50��
					business.sub(i);
				}
			}
		}).start();
		
		for (int i = 1; i <= 50; i++){ 	//�ܹ�ѭ��50��
			business.main(i);
		}
	}

}
class Business{
	private Boolean isRun = true;
	public synchronized void main(int i){
		if(isRun){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j = 1; j <= 100; j++){
			System.out.println( "���߳� ��ѭ������"+String.format("%3d", j)+"   ; �������"+i);
		}
		isRun = true;
		this.notify();
		
	}

	public synchronized void sub(int i){
		if(!isRun){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			for(int j = 1; j <= 10; j++){
				System.out.println( "--->���߳� ��ѭ������"+j+"   ; �������"+i);
			
			isRun = false;
			this.notify();
		}
	}
}