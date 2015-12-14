package com.xiaoyang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/*
 *��һ��������һ���̳߳��������ִ������Ķ��̡߳�excutors
 *�ڶ����� ������Ҫִ�е�����ʵ��Callable�ӿڣ�������һ��call����������ļ����߼��Ž�ȥ��
 *����������Callable�ľ���ʵ���ഫ��FutureTask���档FutureTaskʵ����RunnableFuture��
 *	    RunnableFuture�̳���Runnable ��Future�ӿ�
 *
 *���Ĳ���excutors.submit(futureTask); ִ��
 *���岽��excutors.shutdown();
 *
 * */
public class CallableFuture {

	public static void main(String[] args) {
/*
//		����һ���̳߳� ����ֻ��һ���߳�
		ExecutorService threadPool =  Executors.newSingleThreadExecutor();
		Future<String> future =
			threadPool.submit(new Callable<String>() {
														public String call() throws Exception {
															Thread.sleep(2000);
															return "hello";
														};
													}
		);
		
		System.out.println("�ȴ����");
		try {
			// futrue.get һֱ������ ���ؽ��			
			System.out.println("�õ������" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		
		
		/*ExecutorService threadPool2 =  Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		for(int i=1;i<=10;i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		
		for(int i=0;i<10;i++){
			try {
				System.out.println(
						completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}*/
			
		
		//��һ�ַ�ʽ
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();
         
        //�ڶ��ַ�ʽ��ע�����ַ�ʽ�͵�һ�ַ�ʽЧ�������Ƶģ�ֻ����һ��ʹ�õ���ExecutorService��һ��ʹ�õ���Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/
		
		
			/*
			//			����һ
			//����һ���̳߳�
	        ExecutorService executor = Executors.newCachedThreadPool();
	        //����һ������
	        Task task = new Task();
	        //����һ��futrue   Future���Ƕ��ھ����Runnable����Callable�����ִ�н������ȡ������ѯ�Ƿ���ɡ���ȡ�����
	        //			             ��Ҫʱ����ͨ��get������ȡִ�н�����÷���������ֱ�����񷵻ؽ����
	        //���̳߳������ύ���� task
	        Future<Integer> result = executor.submit(task);
	        //ִ��������   �̳߳عر�
	        executor.shutdown();    */
	        
	        //���߳�����1��
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e1) {
	            e1.printStackTrace();
	        }
	         
	        System.out.println("���߳���ִ������");
	         
	        try {
	        //Futrue�� ��ȡ���	
	            System.out.println("task���н��"+futureTask.get());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (ExecutionException e) {
	            e.printStackTrace();
	        }
	         
	        System.out.println("��������ִ�����");
	    } 
	
	}
	class Task implements Callable<Integer>{
	    @Override
	    public Integer call() throws Exception {
	        System.out.println("���߳��ڽ��м���");
	        Thread.sleep(3000);
	        int sum = 0;
	        for(int i=0;i<100;i++)
	            sum += i;
	        return sum;
	    }
		
	    
	    
		
		
}