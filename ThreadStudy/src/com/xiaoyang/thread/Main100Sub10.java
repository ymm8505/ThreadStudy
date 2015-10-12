package com.xiaoyang.thread;

public class Main100Sub10 {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++){ 	//总共循环50次
					business.sub(i);
				}
			}
		}).start();
		
		for (int i = 1; i <= 50; i++){ 	//总共循环50次
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
			System.out.println( "主线程 内循环次数"+String.format("%3d", j)+"   ; 总体次数"+i);
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
				System.out.println( "--->子线程 内循环次数"+j+"   ; 总体次数"+i);
			
			isRun = false;
			this.notify();
		}
	}
}