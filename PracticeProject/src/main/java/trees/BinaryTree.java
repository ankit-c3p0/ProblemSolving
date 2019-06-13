package trees;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import linkedlist.LinkedList;

public class BinaryTree {

	Node root;
	public BinaryTree() {
		root = null;
	}
	
	void printGivenLevel(Node root, int level) {
		if(root == null) 
			return;
		if(level == 1) {
			System.out.println(root.data + " ");
		}
		else if (level > 1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	// get height of the tree
	int height(Node root) {
		if(root == null) 
			return 0;
		else {

			int lheight = height(root.left);
			int rheight = height(root.right);
			
			if(lheight > rheight) 
				return lheight+1;
			else 
				return rheight+1;
		}
	}
	
	void printLevelOrder(){
		int h = height(root);
		for(int i=1; i<=h; i++) {
			printGivenLevel(root, i);
		}
	}
	
	public void printLevelOrderUsingQueue() {
		
		Queue<Node> queue = new ArrayBlockingQueue<>(10);
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.data + " ");
			
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
	}
	
	public int sum(int a , int b) {
		return 1;
	}

	public int sum(Integer a , Integer b) {
		return 1;
	}

	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
	       tree.root= new Node(1); 
	       tree.root.left= new Node(2); 
	       tree.root.right= new Node(3); 
	       tree.root.left.left= new Node(4); 
	       tree.root.left.right= new Node(5); 
	         
//	       System.out.println("Level order traversal of binary tree is "); 
//	       tree.printLevelOrder(); 
	       
//	       System.out.println("Level order traversal of binary tree with Queue is "); 
//	       tree.printLevelOrderUsingQueue();
	       
	       Integer a =1;
	       Integer b =1;
	       
	       System.out.println(tree.sum(a, b));
	}
}
