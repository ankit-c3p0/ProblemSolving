package linkedlist;

public class LinkedList {

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		this.head = null;
		size = 0;
	}

	boolean isEmpty() {
		
		return head == null;
	}

	int getSize() {

		return size;
	}

	public void insert(int v) {
		
		Node newNode = new Node(v, null);
		size++;
		if(head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public Node delete(int position) {

		if (position ==1) {
			head = head.getNext();
			size--;
			return head;
		}
		if (position == size) {
			Node s = head;
			Node t = head;
			
			while(s!=tail) {
				t = s;
				s = s.getNext();
			}
			tail = t;
			tail.setNext(null);
			size--;
			return s;
		}
		Node ptr = head;
		position = position-1;
		Node tmp =  null;
		for(int i=1; i<size-1; i++) {
			if(i==position) {
				tmp = ptr.getNext();
				tmp = tmp.getNext();
				ptr.setNext(tmp);
				break;
			}
			ptr = ptr.getNext();
		}
		size--;
		return tmp;
	}

	boolean isPresent(int key) {

		Node ptr = head;
		while(ptr.getNext() != null) {
			if(ptr.getValue() == key) {
				return true;
			}
			ptr = ptr.getNext();
		}
		return false;
	}
}
