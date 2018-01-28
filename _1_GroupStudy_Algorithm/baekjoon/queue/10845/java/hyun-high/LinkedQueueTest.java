package queue2;

import java.util.Queue;
import java.util.Scanner;

class LinkedQueue {
	
	private class Node {
		private Object data;
		private Node nextNode;
		
		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}
	private Node head;
	private Node rear;
	
	public LinkedQueue() {
		this.head = null;
		this.rear = null;
	}
	
	public int isEmpty() {
		return ((head == null) ? 1 : 0);
	}
	
	public void push(Object item) {
		Node newNode = new Node(item);
		
		if(head == null)
			head = newNode;
		else
			head.nextNode = newNode;
		rear = newNode;
	}
	
	public Object front() {
		if(isEmpty() == 1) return -1;
		
		return head.data;
	}
	
	public Object back() {
		if(isEmpty() == 1) return -1;
		return rear.data;
	}
	
	public int size() {
		int count;
		Node pnt = head;
		
		for(count = 0; pnt != null; count++)
		{
			pnt = pnt.nextNode;
		}
		return count;
	}
	
	public Object pop() {
		if(isEmpty() == 1)
			return -1;
		Object item;
		item = head.data;
		head = head.nextNode;
		return item;
	}

}


public class LinkedQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		LinkedQueue queue = new LinkedQueue();
		do {
		String input = scan.nextLine();
		String[] inputs = input.split(" ");
		if(inputs[0].equals("exit"))	{scan.close(); return;}
		switch(inputs[0]) {
			case "push":	queue.push(inputs[1]);	break;
			case "pop":		System.out.println(queue.pop());				break;
			case "front":	System.out.println(queue.front());			break;
			case "back":	System.out.println(queue.back());				break;
			case "size":	System.out.println(queue.size());				break;
			case "empty":	System.out.println(queue.isEmpty());			break;
			}
			
		}while(true);
	}
		
	}

