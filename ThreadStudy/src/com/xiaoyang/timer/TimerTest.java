package com.xiaoyang.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	static int count = 0;
	public static void main(String[] args) {
		
//		һ��ը��һ��֮��ը ը�� ��û��
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Bombing����1����" +new Date().getSeconds()+"---->"+count);
			}
		}, 1000);
		
		
//		һ��ը��һ��֮��ը ը�� �Ժ� ÿ��2����ըһ��
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Bombing����2����" +new Date().getSeconds()+"---->"+count);
			}
		}, 1000,2000);		
	
	
//////////////////////////////ÿ��2�� ըһ�� ÿ��4��ըһ��////////////////////////////
	class myTimerTask extends TimerTask{
		@Override
		public void run() {
			count = (count+1)%2;
			System.out.println("Bombing����3����" +new Date().getSeconds()+"---->"+count);
			new Timer().schedule(new myTimerTask(), 2000+(2000*count));
		}
	}
	new Timer().schedule(new myTimerTask(), 2000);
////////////////////////////ÿ��2�� ըһ�� ÿ��4��ըһ��////////////////////////////
	
	
	
	}
}
