package com.xiaoyang.golf;

	//内部类实现懒汉式
	  public class Singleton {      
	      private static class SingletonHolder{
	          //单例变量  
	          private static Singleton instance = new Singleton();
	      }
	      
	      //私有化的构造方法，保证外部的类不能通过构造器来实例化。
	      private Singleton() {
	    	  System.out.println("调用了我几次");
	      }      
	      
	      //获取单例对象实例
	      public static Singleton getInstance() {
	          System.out.println("我是内部类单例！");
//	          在返回的时候再去 调用初始化SingletonHolder类的成员变量
	          return SingletonHolder.instance;
	      }
	  }
