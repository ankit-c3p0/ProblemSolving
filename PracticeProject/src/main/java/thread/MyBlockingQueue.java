package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
	
	private Queue<E> queue;
	private int size;
	private ReentrantLock lock = new ReentrantLock(true);
	
	public MyBlockingQueue(int size) {
		queue = new LinkedList<>();
		this.size = size;
	}

	public void put(E e) {
		queue.add(e);
	}
	
	public E take() {
		E item = queue.remove();
		return item;
	}
}
