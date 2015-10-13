package com.xiaoyang.itcast;

/*������ ���߳����1-10 
 * Ȼ�����߳����1-50 Ȼ�����߳����������ѭ���ۼ�50��
 * ʵ��˼·
 * 1�����ȳ��������� ����һ�����߳� mian�߳� 
 * 2���ٴ���һ���߳���Ϊ���߳�
 * 3�������ڲ���50����ѭ���͸���10��50����ѭ��д�ã���ʱ�����������ǻύ�������
 * 4������synchronized�ؼ���  ���߳� ���ڱ�����ֽ�����    ����ѭ�����ϣ�����ÿ��ѭ����ʱ�����߳̽��벻���Լ���ѭ����
 * 	   �����Լ�ѭ���������ԡ�
 * 5������һ���������࣬����д��������ķ�����һ�������̡߳�һ�������̡߳����������ͬʱҲ�������
 * 6����ʱ��Ȼ�ܱ�֤�Լ������ʱ�����߳̽��벻�˵����Լ���������ܱ�ֻ֤��һ�ε������
 * 7������Flag�жϣ���������Լ�������Լ�wait() �ȴ����ѡ�
 * 				   ������Լ������������Ժ󣬸���Flag��ֵ������notify���ѵȴ����̡߳�
 * 8����7����߼��������߳� �����߳�����
 * 
 * */
public class ThreadSyn {

	public static void main(String[] args) {
		final Buesiness buesiness = new Buesiness();
		// ���߳����10
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					buesiness.Main(i);
				}
			}
		}).start();

		// ���߳����50
		for (int i = 1; i <= 50; i++) {
			buesiness.Sub(i);
		}

	}

	static class Buesiness {
		boolean isRun = true;
		public synchronized void Main(int i) {
			while(isRun){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (int j = 1; j <= 50; j++) {
				System.out.println("Mian�߳�����-->"	+ Thread.currentThread().getName() + "    ��ѭ������" + j	+ "��ѭ������" + i);
			}
			isRun = true;
			this.notify();
		}

		public synchronized void Sub(int i) {
			while(!isRun){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println("Sub�߳�����-->"	+ Thread.currentThread().getName()	+ "    ��ѭ������" + j + "��ѭ������" + i);
			}
			isRun = false;
			this.notify();
		}
	}

}
