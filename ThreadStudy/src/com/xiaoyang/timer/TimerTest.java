package com.xiaoyang.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	static int count = 0;
	public static void main(String[] args) {
		
//		一个炸弹一秒之后炸 炸完 就没了
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Bombing……1……" +new Date().getSeconds()+"---->"+count);
			}
		}, 1000);
		
		
//		一个炸弹一秒之后炸 炸完 以后 每隔2秒钟炸一次
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Bombing……2……" +new Date().getSeconds()+"---->"+count);
			}
		}, 1000,2000);		
	
	
//////////////////////////////每隔2秒 炸一次 每隔4秒炸一次////////////////////////////
	class myTimerTask extends TimerTask{
		@Override
		public void run() {
			count = (count+1)%2;
			System.out.println("Bombing……3……" +new Date().getSeconds()+"---->"+count);
			new Timer().schedule(new myTimerTask(), 2000+(2000*count));
		}
	}
	new Timer().schedule(new myTimerTask(), 2000);
////////////////////////////每隔2秒 炸一次 每隔4秒炸一次////////////////////////////
	
	
	
	}
}
