package threadrunninginsequence;

public class ThreadB implements Runnable {

	ResouceLock lock;

	public ThreadB(ResouceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 30; i++) {

					while (lock.i != 2) {
						lock.wait();
					}
					System.out.println("Global");
					Thread.sleep(100);
					lock.i = 3;
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
