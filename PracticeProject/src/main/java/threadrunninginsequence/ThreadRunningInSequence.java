package threadrunninginsequence;

public class ThreadRunningInSequence {
	
	public static void main(String[] args) {
		
		ResouceLock lock = new ResouceLock();
		
		ThreadA a = new ThreadA(lock);
		ThreadB b = new ThreadB(lock);
		ThreadC c = new ThreadC(lock);
		
		new Thread(a).start();
		new Thread(b).start();
		new Thread(c).start();
		
	}

}
