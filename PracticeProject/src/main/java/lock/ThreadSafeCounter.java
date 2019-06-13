package lock;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadSafeCounter {

	private int value;

	public synchronized int getValue() {
		System.out.println("getting value");
		return value;
	}

	public synchronized void incrementValue() {
		value++;
	}

	public synchronized void setValue(final int value) {
		this.value = value;
		System.out.println("setting value");
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static void main(String[] args) {

		ThreadSafeCounter tc1 = new ThreadSafeCounter();
		ThreadSafeCounter tc2 = new ThreadSafeCounter();

		new Thread(new Runnable() {

			@Override
			public void run() {
				tc1.setValue(0);

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				tc1.getValue();

			}
		}).start();

//		tc2.incrementValue();
//		tc1.toString();
	}
}