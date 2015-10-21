package com.xiaoyang.golf.ProCom;

public class T_Main {
	
	/*
	 生产者消费者模式说明：
	1.生产者只在仓库未满时进行生产，仓库满时生产者进程被阻塞；
	2.消费者只在仓库非空时进行消费，仓库为空时消费者进程被阻塞；
	3.当消费者发现仓库为空时会通知生产者生产；
	4.当生产者发现仓库满时会通知消费者消费；
	
	【【【【【【把notify 改为notifyAll 避免假死】】】】】】
	*/

	public static void main(String[] args) {
		String lock =  new String("");
		T_Product p = new T_Product(lock);
		T_Customer c = new T_Customer(lock);
		
		ThreadP[] threadP = new ThreadP[2];
		ThreadC[] threadC = new ThreadC[2];
		
		for(int i=0;i<2;i++){
			threadP[i] = new ThreadP(p);
			threadP[i].setName("生产者"+(i+1));
			threadC[i] = new ThreadC(c);
			threadC[i].setName("消费者"+(i+1));
			
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