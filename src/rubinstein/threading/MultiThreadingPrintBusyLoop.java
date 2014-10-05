package rubinstein.threading;

import java.util.concurrent.CountDownLatch;

public class MultiThreadingPrintBusyLoop {
	public static void main(String[] args) throws InterruptedException{
		
		Thread threads[] = new Thread[5];
		
		CountDownLatch latch = new CountDownLatch(5);
		
		for(int i = 0; i < threads.length; i++){
			final int current= i;
			threads[i] = new Thread(){
				public void run(){
					System.out.println(current);
					latch.countDown();
				}
			};
			threads[i].start();
		}
	
		latch.await();
		
		
		/*	//bz loop, continually checks for a condition - not usually good
	    //latch essentially does this
	      
		int alive = threads.length;
		while(alive > 0){
			alive = 0;
			for(int i = 0; i < threads.length; i++){
				if(threads[i].isAlive()){
					alive++;
				}
			}
		}
		System.out.println("finished");
		*/
	}
	
}
