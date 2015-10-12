package com.xiaoyang.thread;

/*
 * ���߳�ѭ��10�Σ��������߳�ѭ��100��
 * �����ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��100��
 * ���ѭ��50�Σ���д������
 * 
 * */
public class TestMainSubThread {
	static boolean runflag = true;

	public static void main(String[] args) {

		class mianRunnable implements Runnable {
			@Override
			public void run() {
				if (runflag) {
					for (int i = 0; i < 100; i++) {
						System.out.println("�������߳�ѭ����" + (i + 1) + "����");
					}
				} else {
					runflag = false;
				}
			}
		}

		class subRunnable implements Runnable {
			@Override
			public void run() {
				if (runflag) {
					for (int i = 0; i < 10; i++) {
						System.out.println("���߳�ѭ����" + (i + 1) + "����");
					}
				} else {
					runflag = false;
				}
			}
		}

		Thread mianThread = new Thread(new mianRunnable());
		Thread subThread = new Thread(new subRunnable());
		mianThread.start();
		subThread.start();
	}

}
