package test;

import java.time.temporal.IsoFields;

public class BST {

	private static Node root;
	
	public BST() {
		root = null;
	}
	
	public static void insert(int data) {
		root = insert(root, data);
	}
	public static Node insert(Node node, int data) {
		
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.getData()) {
//				System.out.println("Adding to left ... ");
				node.left = insert(node.left, data);
			} else {
//				System.out.println("Adding to right ...");
				node.right = insert(node.right, data);
			}
		}
		return node;	
	}
	
	//tree traversal
	
	static void inorder(Node root) {
		
		if (root != null) {
			 inorder(root.left);
			 System.out.print(root.data + " ");
			 inorder(root.right);
		}
	}

	static void preorder(Node root) {
		
		if (root != null) {
			System.out.print(root.data+ " ");
			preorder(root.left);
			 preorder(root.right);
		}
	}

	static void postorder(Node root) {
		
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			 System.out.print(root.data+ " ");
		}
	}
	
	// BST search node
	static boolean searchNode(Node node, int val) {
		
		boolean isFound = false;
		while((node !=null) && !isFound) {
			
			int rval = node.getData();
			if(val > rval)
				node = node.getRight();
			else if (val < rval)
				node = node.getLeft();
			else {
				isFound = true;
				break;
			}
			isFound = searchNode(node, val);
		}
		return isFound;
		
	}

	//BST deletion
	static Node delete(Node root, int k) {
		
		Node p, p2, n;
		if(root.getData() == k) {
			
			Node lt, rt;
			lt = root.getLeft();
			rt = root.getLeft();
			if(rt == null && lt == null)
				return null;
			else if(lt == null) {
				p = rt;
				return p;
			} else if(rt == null) {
				p = lt;
				return p;
			} else {
				p2=rt;
				p = rt;
				while(p.getLeft() !=null) {
					p = p.getLeft();
				}
				p.setLeft(lt);
				return p2;
			}
		}
		if(k<root.getData()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		}
		if(k>root.getData()) {
			n= delete(root.getRight(), k);
			root.setRight(n);
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 5, 1, 6, 3, 8, 7, 9};
		for(int val: arr) {
			System.out.print(val+ " ");
			insert(val);
		}
		System.out.println();
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		
		System.out.println(searchNode(root, 9));
		
		delete(root, 7);
		preorder(root);
	}
}
