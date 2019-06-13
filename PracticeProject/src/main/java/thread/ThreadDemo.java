package thread;

public class ThreadDemo extends Thread implements Runnable {

	public static void main(String[] args) {
		Thread t =new Thread(new ThreadDemo());
		t.start();
	}
}
