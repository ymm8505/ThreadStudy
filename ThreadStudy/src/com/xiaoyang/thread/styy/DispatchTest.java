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
		System.out.println("开始调用 父类的printMessage方法");
		System.out.println("Base.x = " + x);
	}
}

class Sub extends Base {
	int x = 30;
	
//	子类的构造 方法先回去调用父类的构造方法
	public Sub() {
		this.printMessage();
		x = 40;
	}

	public void printMessage() {
		System.out.println("开始调用 子类的printMessage方法");
		System.out.println("Sub.x = " + x);
	}
}