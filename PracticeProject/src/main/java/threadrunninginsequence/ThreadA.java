package threadrunninginsequence;

public class ThreadA implements Runnable {

	ResouceLock lock;

	public ThreadA(ResouceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 30; i++) {

					while (lock.i != 1) {
						lock.wait();
					}
					System.out.println("Sapient");
					Thread.sleep(100);
					lock.i = 2;
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
