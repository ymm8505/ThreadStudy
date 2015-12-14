package com.xiaoyang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/*
 *第一步：创建一个线程池用来存放执行任务的多线程。excutors
 *第二步： 创建需要执行的任务，实现Callable接口，里面有一个call方法，具体的计算逻辑放进去。
 *第三步：把Callable的具体实现类传入FutureTask里面。FutureTask实现了RunnableFuture，
 *	    RunnableFuture继承了Runnable 和Future接口
 *
 *第四步：excutors.submit(futureTask); 执行
 *第五步：excutors.shutdown();
 *
 * */
public class CallableFuture {

	public static void main(String[] args) {
/*
//		创建一个线程池 里面只有一个线程
		ExecutorService threadPool =  Executors.newSingleThreadExecutor();
		Future<String> future =
			threadPool.submit(new Callable<String>() {
														public String call() throws Exception {
															Thread.sleep(2000);
															return "hello";
														};
													}
		);
		
		System.out.println("等待结果");
		try {
			// futrue.get 一直阻塞到 返回结果			
			System.out.println("拿到结果：" + future.get());
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
			
		
		//第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();
         
        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/
		
		
			/*
			//			方案一
			//创建一个线程池
	        ExecutorService executor = Executors.newCachedThreadPool();
	        //创建一个任务
	        Task task = new Task();
	        //创建一个futrue   Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。
	        //			             必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
	        //往线程池里面提交任务 task
	        Future<Integer> result = executor.submit(task);
	        //执行完任务   线程池关闭
	        executor.shutdown();    */
	        
	        //主线程休眠1秒
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e1) {
	            e1.printStackTrace();
	        }
	         
	        System.out.println("主线程在执行任务");
	         
	        try {
	        //Futrue来 获取结果	
	            System.out.println("task运行结果"+futureTask.get());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (ExecutionException e) {
	            e.printStackTrace();
	        }
	         
	        System.out.println("所有任务执行完毕");
	    } 
	
	}
	class Task implements Callable<Integer>{
	    @Override
	    public Integer call() throws Exception {
	        System.out.println("子线程在进行计算");
	        Thread.sleep(3000);
	        int sum = 0;
	        for(int i=0;i<100;i++)
	            sum += i;
	        return sum;
	    }
		
	    
	    
		
		
}