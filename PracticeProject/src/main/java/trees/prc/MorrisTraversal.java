package trees.prc;


public class MorrisTraversal {
	
	public void inorder(Node root) {
		
		Node current = root;
		
		while(current != null) {
			
			if(current.left == null) {
				System.out.println(current.data + " ");
				current = current.right;
			}
			else {
				Node predecessor = current.left;
				while(predecessor.right != current && current.right != null) {
					predecessor = predecessor.right;
				}
				if(predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				} else {
					predecessor.right = null;
					System.out.println(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(50, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(7, root);
        root = bt.addNode(9, root);
        root = bt.addNode(-20, root);
        root = bt.addNode(30, root);
        MorrisTraversal mt = new MorrisTraversal();
        mt.inorder(root);
        System.out.println();
		
	}
}
