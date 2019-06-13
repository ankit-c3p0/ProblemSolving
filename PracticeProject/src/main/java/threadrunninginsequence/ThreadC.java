package threadrunninginsequence;

public class ThreadC implements Runnable {

	ResouceLock lock;

	public ThreadC(ResouceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 30; i++) {

					while (lock.i != 3) {
						lock.wait();
					}
					System.out.println("Market");
					Thread.sleep(100);
					lock.i = 1;
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
