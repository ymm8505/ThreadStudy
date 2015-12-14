package com.xiaoyang.thread;

import java.util.Random;

public class ThreadLocalOkMore {
	private static ThreadLocal<MoreVarStore> x = new ThreadLocal<MoreVarStore>();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int date = new Random().nextInt();
					MoreVarStore dateSource = new MoreVarStore();

					dateSource.setDateType(Thread.currentThread().getName());
					dateSource.setDateSource(date + "");
					System.out.println("setDateSource    " + date
							+ "  setDateType---->"
							+ Thread.currentThread().getName());
					x.set(dateSource);
					new A().getDate();
					new B().getDate();
				}
			}).start();
		}
	}

	static class A {
		public void getDate() {
			System.out.println(Thread.currentThread().getName()
					+ " A 取到的DateSource()为---------->"
					+ x.get().getDateSource() + "------------->DateType()"
					+ x.get().getDateType());
		}
	}

	static class B {
		public void getDate() {
			System.out.println(Thread.currentThread().getName()
					+ " B 取到的DateSource()为---------->"
					+ x.get().getDateSource() + "------------->DateType()"
					+ x.get().getDateType());
		}
	}
}

class MoreVarStore {
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