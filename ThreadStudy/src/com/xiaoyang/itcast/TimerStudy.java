package com.xiaoyang.itcast;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 两个炸弹 每隔2秒炸一次 然后每隔4秒炸一次
 * 
 * 
 * */
public class TimerStudy {
	static int count = 0;

	public static void main(String[] args) {

//		new Timer().schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("Bombing……");
//				}
//			}, 1000, 3000); //1秒之后炸 每隔3秒之后炸一次
		
/*		TimerTask timerTask1 = new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date().getSeconds()+"timerTask1 Bombing");
				
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						count = (count+1)%2;
						System.out.println(new Date().getSeconds()+"timerTask2 Bombing+-->"+count);
					}},0,2000+(2000*count));
			}
		};
		new Timer().schedule(timerTask1,2000);*/
		
		class myTimerTask extends TimerTask {
			@Override
			public void run() {
				count = (count + 1) % 2;
				System.out.println(new Date().getSeconds()	+ "timerTask2 Bombing+-->" + count);
				new Timer().schedule(new myTimerTask(), 2000 + 2000 * count);
			}
		}
		new Timer().schedule(new myTimerTask(), 2000);
		
	}
	
	
}
