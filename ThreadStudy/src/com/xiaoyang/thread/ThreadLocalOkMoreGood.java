package com.xiaoyang.thread;

import java.util.Random;

public class ThreadLocalOkMoreGood {
//	private static ThreadLocal<MoreVarStore> x = new ThreadLocal<MoreVarStore>();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int date = new Random().nextInt();
//					MoreVarStore dateSource = new MoreVarStore();
//					dateSource.setDateType(Thread.currentThread().getName());
//					dateSource.setDateSource(date + "");
					ThreadLocalMoreVar.getThreadLocalInstance().setDateType(date + "");
					ThreadLocalMoreVar.getThreadLocalInstance().setDateSource(Thread.currentThread().getName());
					System.out.println("setDateSource    " + date+ "  setDateType---->"+ Thread.currentThread().getName());
//					x.set(dateSource);
					new A().getDate();
					new B().getDate();
				}
			}).start();
		}
	}

	static class A {
		public void getDate() {
			System.out.println(Thread.currentThread().getName()
					+ " A ȡ����DateSource()Ϊ---------->"
					+ ThreadLocalMoreVar.getThreadLocalInstance().getDateSource() + "------------->DateType()"
					+ ThreadLocalMoreVar.getThreadLocalInstance().getDateType());
		}
	}

	static class B {
		public void getDate() {
			System.out.println(Thread.currentThread().getName()
					+ " B ȡ����DateSource()Ϊ---------->"
					+ ThreadLocalMoreVar.getThreadLocalInstance().getDateSource() + "------------->DateType()---->"
					+ ThreadLocalMoreVar.getThreadLocalInstance().getDateType());
		}
	}
}

class ThreadLocalMoreVar {
	//������һ�� �����Լ��� Ĭ���޲ι��췽��     ��ֹ����ͨ��new����������
	private ThreadLocalMoreVar() {
	}
	
	//���ڲ�����һ���Լ��Ķ��� ˽��  ��̬ ��ֹ�������
//	private static ThreadLocalMoreVar  threadLocalMoreVar = null;
//	����һ��ThreadLocal �����������
	private static ThreadLocal<ThreadLocalMoreVar>  map = new ThreadLocal<ThreadLocalMoreVar>();
	
	public static ThreadLocalMoreVar getThreadLocalInstance(){
		ThreadLocalMoreVar instance = map.get();
		if (instance == null)
			instance = new ThreadLocalMoreVar();
			map.set(instance);
		return instance;
	}
	

	private String DateSource;
	private String DateType;

	public String getDateSource() {
		return DateSource;
	}

	public void setDateSource(String dateSource) {
		DateSource = dateSource;
	}

	public String getDateType() {
		return DateType;
	}

	public void setDateType(String dateType) {
		DateType = dateType;
	}

}