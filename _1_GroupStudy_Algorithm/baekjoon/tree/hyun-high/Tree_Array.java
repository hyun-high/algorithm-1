package tree;

import java.util.Scanner;

class TreeA {
	private Object[] root;
	private int size;
	private int max;
	public TreeA(int size) {
		root = null;
		this.size = size;
	}
	
	public void insertNode(String str) {
		String values[] = str.split(" ");
		
		if(root == null) {
			//max = (int)Math.pow(2, size+1);
			root = new Object[(int)Math.pow(2, size+1)];
			
			root[1] = values[0];
			root[2] = values[1];
			root[3] = values[2];
			max = 3;
		}else {
			for(int i = 1; i <= max; i++) {
				if(root[i] != null && root[i].equals(values[0])) {
					root[i * 2] = values[1];
					root[i * 2 + 1] = values[2];
					if(max < (i*2+1)) max = i * 2 + 1;
					break;
				}
			}
		}
	
	}
	
	public void preorder(int index) {
		if(root[index].equals(".")) return;
		
		System.out.print(root[index]);
		
		preorder(index*2);
		preorder(index*2+1);
	}
	
	public void inorder(int index) {	
		if(root[index].equals(".")) return;
		
		inorder(index*2);
		System.out.print(root[index]);
		inorder(index*2+1);
	}
	
	public void postorder(int index) {	
		if(root[index].equals(".")) return;
	
		postorder(index*2);
		postorder(index*2+1);
		System.out.print(root[index]);
	}
}

public class Tree_Array {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int nodeNum = Integer.parseInt(scan.nextLine());
		
		TreeA tree = new TreeA(nodeNum);
		String node;
		
		for(int i = 0; i < nodeNum; i++) {
			node = scan.nextLine();
			tree.insertNode(node);	
		}
		
		tree.preorder(1);
		System.out.println("");
		tree.inorder(1);
		System.out.println("");
		tree.postorder(1);
		
	}

}
