package threadrunninginsequence;

public class EvenPrinter implements Runnable {
	
	ResouceLock lock;
	int limit;
	
	public EvenPrinter(ResouceLock lock, int limit) {
		
		this.lock = lock;
		this.limit = limit;
	}
	
	@Override
	public void run() {

		try {
			
			synchronized (lock) {
				
				for(int i=0; i<limit; i+=2) {
					
					while(lock.i != 2) {
						lock.wait();
					}
					
					System.out.println(i);
					Thread.sleep(100);
					lock.i = 1;
					lock.notifyAll();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
