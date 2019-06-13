package blockingqueue;


import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<E> {
	
	private Queue<E> queue;
	private int size;
	
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
