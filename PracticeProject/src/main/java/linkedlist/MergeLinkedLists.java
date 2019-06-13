package linkedlist;

public class MergeLinkedLists {

	public static Node merge(Node head1, Node head2) {
		
		Node mergedList = null;
		if(head1 == null)
			return head2;
		if(head2 == null) 
			return head1;
		
		if(head1.getValue() < head2.getValue()) {
			mergedList = head1;
			mergedList.setNext(merge(head1.getNext(), head2));
		} else {
			mergedList = head2;
			mergedList.setNext(merge(head1, head2.getNext()));
		}
		return mergedList;
	}
	
	public static void insert(Node head, int data) {
		while(head.next != null) {
			head = head.next;
		}
		head.next = new Node(data);
	}
	
	
	public static void print(Node head) {
		while(head != null) {
			System.out.printf("%d ",head.value);
			head = head.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		int[] data1 = {1,3,5,9};
		Node head1 = new Node(data1[0]);
		
		for(int count = 1; count < data1.length; count++)
			MergeLinkedLists.insert(head1,data1[count]);
		
		System.out.printf("Linked list 1 is : ");
		MergeLinkedLists.print(head1);
		
		int[] data2 = {2,4,5,6,10};
		Node head2 = new Node(data2[0]);
		for(int count = 1; count < data2.length; count++)
			MergeLinkedLists.insert(head2,data2[count]);
		
		System.out.printf("Linked list 2 is : ");
		MergeLinkedLists.print(head2);
		
		Node mergedList = MergeLinkedLists.merge(head1, head2);
		System.out.println("Merged lists:");
		print(mergedList);
	}
}
