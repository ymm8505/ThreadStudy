package com.xiaoyang.golf;

	//�ڲ���ʵ������ʽ
	  public class Singleton {      
	      private static class SingletonHolder{
	          //��������  
	          private static Singleton instance = new Singleton();
	      }
	      
	      //˽�л��Ĺ��췽������֤�ⲿ���಻��ͨ����������ʵ������
	      private Singleton() {
	    	  System.out.println("�������Ҽ���");
	      }      
	      
	      //��ȡ��������ʵ��
	      public static Singleton getInstance() {
	          System.out.println("�����ڲ��൥����");
//	          �ڷ��ص�ʱ����ȥ ���ó�ʼ��SingletonHolder��ĳ�Ա����
	          return SingletonHolder.instance;
	      }
	  }
