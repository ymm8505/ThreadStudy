/*import java.util.concurrent.BlockingQueue;


 * BlockingQueue 队列   实现生产者 消费者模式
 * 
 * 
class Producer implements Runnable {
	private final BlockingQueue queue;

	Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
	     try {
	       while (true) { 
	    	   queue.put(produce()); 
	    	   }
	     } catch (InterruptedException ex) { 
//	    	 ... handle ...
	    	 ex.printStackTrace();
	    	 }
	}	
	
	Object produce() {
		System.out.println("我是 produce");
		return "";
		}
}

class Consumer implements Runnable {
	private final BlockingQueue queue;

	Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
     try {
       while (true) { consume(queue.take()); }
     } catch (InterruptedException ex) { 	
    	 ex.printStackTrace();
//    	 ... handle ...
     }
   }

	void consume(Object x) {
//		... 
		}
}

class Setup {
	void main() {
		BlockingQueue q = new SomeQueueImplementation();
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}
*/