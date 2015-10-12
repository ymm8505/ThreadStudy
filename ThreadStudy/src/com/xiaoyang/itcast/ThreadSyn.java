package com.xiaoyang.itcast;

/*面试题 子线程输出1-10 
 * 然后主线程输出1-50 然后子线程再输出依次循环累计50次
 * 实现思路
 * 1、首先程序本身运行 就是一个主线程 mian线程 
 * 2、再创建一个线程作为子线程
 * 3、先在内部把50次外循环和各自10、50次内循环写好，此时的问题是他们会交叉输出。
 * 4、加上synchronized关键字  主线程 锁在本类的字节码上    把内循环锁上，保障每次循环的时候别的线程进入不了自己的循环。
 * 	   保障自己循环的完整性。
 * 5、创建一个单独的类，里面写两个输出的方法，一个是主线程、一个是子线程。方便加锁。同时也方便调度
 * 6、此时虽然能保证自己输出的时候别的线程进入不了但是自己的输出不能保证只是一次的输出。
 * 7、加入Flag判断，如果不该自己输出，自己wait() 等待唤醒。
 * 				   如果该自己输出，输出完以后，更改Flag的值，并且notify唤醒等待的线程。
 * 8、第7点的逻辑加在主线程 和子线程上面
 * 
 * */
public class ThreadSyn {

	public static void main(String[] args) {
		final Buesiness buesiness = new Buesiness();
		// 子线程输出10
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					buesiness.Main(i);
				}
			}
		}).start();

		// 主线程输出50
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
				System.out.println("Mian线程运行-->"	+ Thread.currentThread().getName() + "    内循环次数" + j	+ "外循环次数" + i);
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
				System.out.println("Sub线程运行-->"	+ Thread.currentThread().getName()	+ "    内循环次数" + j + "外循环次数" + i);
			}
			isRun = false;
			this.notify();
		}
	}

}
