package trees;

import java.util.Stack;

public class InOrderWORecursion {
	
	static TreeNode root;
	static void inorder() {
		Stack<TreeNode> s = new Stack<>();

		if(root == null) {
			return;
		}
		
		TreeNode curr = root;
		while(curr != null && s.size() > 0) {
			
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.println(curr.data + " ");
			curr = curr.right;
		}
	}
	
	public static void main(String[] args) {
		
		InOrderWORecursion tree = new InOrderWORecursion(); 
        root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        inorder(); 
	}
}

class TreeNode 
{ 
    int data; 
    TreeNode left, right; 
  
    public TreeNode(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
}
