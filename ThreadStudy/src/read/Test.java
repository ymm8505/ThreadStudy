package read;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*��һ�⣺���еĳ������ģ�������16����־���󣬲�����Ҫ����16����ܴ�ӡ����Щ��־��
 * ���ڳ���������4���߳�ȥ����parseLog()��������ͷ��ӡ��16����־����
 * ����ֻ��Ҫ����4�뼴�ɴ�ӡ����Щ��־����ԭʼ�������£�
 * 
 * 
 * 
 * ����˼·
*/
	public class Test {
		
		public static void main(String[] args) throws InterruptedException{
			
			//add by yangmm 2015��10��13��11:42:40
			/*for(int i =0 ;i<4;i++){
				new Thread(new Runnable() {
					@Override
					public void run() {
						
					}
				}).start();
			}*/
			
			
			/*final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
			for(int i=0;i<4;i++){
				new Thread(new Runnable(){
					@Override
					public void run() {
						while(true){
							try {
								String log = queue.take();
								parseLog(Thread.currentThread().getName()+log);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
				}).start();
			}*/
			
			System.out.println("begin:"+(System.currentTimeMillis()/1000));
			/*ģ�⴦��16����־������Ĵ��������16����־���󣬵�ǰ������Ҫ����16����ܴ�ӡ����Щ��־��
			�޸ĳ�����룬���ĸ��߳�����16��������4���Ӵ��ꡣ
			*/
			for(int i=0;i<16;i++){  //���д��벻�ܸĶ�
				final String log = ""+(i+1);//���д��벻�ܸĶ�
				{
		    						Test.parseLog(log);
//		    						queue.put(log);
		    			}
				}
			}
		
		//parseLog�����ڲ��Ĵ��벻�ܸĶ�
		public static void parseLog(String log){
			System.out.println(log+":"+(System.currentTimeMillis()/1000));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
	}