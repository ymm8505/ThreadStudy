/*package com.xiaoyang.thread;


 * 子线程循环10次，接着主线程循环5，
 * 接着又回到子线程循环10次，接着再回到主线程又循环5，
 * 如此循环50次，请写出程序。
 * 
 * 

public class Sub10Main5 {
		public static void main(String[] args) throws InterruptedException {
		final Buess buess =  new Buess();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 50;i++){
					try {
						buess.Main(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1;i<= 50;i++){
					try {
						buess.Sub(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		
		
	
		
	}

}
class Buess{
	private Boolean isShowSub = true;
	
	public synchronized void Main(int m) throws InterruptedException{
		while(isShowSub){
			this.wait();
		}
		for(int i = 1;i<= 5;i++){
			System.out.println("Main---->"+i+" MMMM----"+m);
		}
		isShowSub = true;
		this.notify();
		
	}

	public synchronized void Sub(int m) throws InterruptedException{
		while(!isShowSub){
			this.wait();
		}
		for(int i = 1;i<= 10;i++){
			System.out.println("Sub----------------->"+i+" MMMM----"+m);
		}
		isShowSub = false;
		this.notify();
	}

}
*/