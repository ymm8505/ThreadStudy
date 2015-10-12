package com.xiaoyang.thread.styy;

public class DispatchTest {
	public static void main(String[] args) {
	/*	Base b = new Sub();
		System.out.println(b.x);*/
		Sub sub =  new Sub();
		System.out.println(sub.x);
	}
}

class Base {
	int x = 10;

	public Base() {
		this.printMessage();
		x = 20;
	}
	
	public void printMessage() {
		System.out.println("��ʼ���� �����printMessage����");
		System.out.println("Base.x = " + x);
	}
}

class Sub extends Base {
	int x = 30;
	
//	����Ĺ��� �����Ȼ�ȥ���ø���Ĺ��췽��
	public Sub() {
		this.printMessage();
		x = 40;
	}

	public void printMessage() {
		System.out.println("��ʼ���� �����printMessage����");
		System.out.println("Sub.x = " + x);
	}
}