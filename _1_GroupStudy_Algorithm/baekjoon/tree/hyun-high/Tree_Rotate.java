package tree;

import java.util.Scanner;

class TreeB {
	private class Node {
		Object data;
		Node right = null;
		Node left = null;
		
		Node(Object data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		Node(Node left, Object data, Node right){
			this.right = right;
			this.data = data;
			this.left = left;
		}
	}
	
	private Node root = null;
	
	public Node getRoot() {
		return root;
	}
	
	public void insertNode(String str) {
		String values[] = str.split(" ");
		
		Node newnodeLeft = new Node(values[1]);
		Node newnodeRight = new Node(values[2]);
		if(root == null) {
			Node newnode = new Node(newnodeLeft, values[0], newnodeRight);
			root = newnode;
		}	else {
			search(values[0], root);
			if(find == null) return;
			
			find.left = newnodeLeft;
			find.right = newnodeRight;
			find = null;
		}
		//Node node = new Node(values[1], values[0], values[2])
	}
	Node find = null;
	public void search(Object data, Node ptr) {
		if(ptr == null || ptr.data.equals(".")) return;
		if(ptr.data.equals(data)) {
			find = ptr;
		}
		
		if(find == null)search(data, ptr.left);
		if(find == null)search(data, ptr.right);
	}
	
	public void preorder(Node ptr) {
		if(ptr.data.equals(".")) return;
		
		System.out.print(ptr.data);
		preorder(ptr.left);
		preorder(ptr.right);
	}
	
	public void inorder(Node ptr) {
		if(ptr.data.equals(".")) return;
		
		inorder(ptr.left);
		System.out.print(ptr.data);
		inorder(ptr.right);
	}
	
	public void postorder(Node ptr) {
		if(ptr.data.equals(".")) return;
		
		if(ptr.left != null) postorder(ptr.left);
		if(ptr.right != null) postorder(ptr.right);
		System.out.print(ptr.data);
	}
}

public class Tree_Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int nodeNum = Integer.parseInt(scan.nextLine());
		
		TreeB tree = new TreeB();
		String node;
		for(int i = 0; i < nodeNum; i++) {
			node = scan.nextLine();
			
			tree.insertNode(node);
		}
		
		tree.preorder(tree.getRoot());
		System.out.println();
		tree.inorder(tree.getRoot());
		System.out.println();
		tree.postorder(tree.getRoot());
		
	}

}
