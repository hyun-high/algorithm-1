package queue;

import java.util.Scanner;

class ArrayQueue {
	
	private int maxSize = 0;
	private int head = 0, rear = 0;
	private Object[] arrayQueue;
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arrayQueue = new Object[maxSize];
	}
	
	public int isEmpty() {
		return ((head == rear)? 1 : 0);
	}
	public boolean isFull() {
		return (((rear + 1) % maxSize) == head );
	}
	
	public void push(Object item) {
		if(isFull()) {
			System.out.println("The queue is full");
			return;
		}
		rear = (rear + 1) % maxSize;
		arrayQueue[rear] = item; 
	}
	
	public Object front() {
		if(isEmpty() == 1) return -1;
		
		return arrayQueue[head+1];
	}
	
	public Object back() {
		if(isEmpty() == 1) return -1;
		return arrayQueue[rear];
	}
	
	public int size() {
		return Math.abs(head-rear);
	}
	
	public Object pop() {
		if(isEmpty() == 1)
			return -1;
		Object item;
		head = (head + 1) % maxSize;
		item = arrayQueue[head];
		
		return item;
	}

}
public class ArrayQueueTest{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int maxSize = Integer.parseInt(scan.nextLine());
		
		if(maxSize > 100000 || maxSize < 1) return;
		
		ArrayQueue queue = new ArrayQueue(maxSize);
		
		for(int i = 0; i < maxSize; i++) {
			
			String input = scan.nextLine();
			String[] inputs = input.split(" ");
			
			switch(inputs[0]) {
			case "push":	queue.push(inputs[1]);	break;
			case "pop":		System.out.println(queue.pop());				break;
			case "front":	System.out.println(queue.front());			break;
			case "back":	System.out.println(queue.back());				break;
			case "size":	System.out.println(queue.size());				break;
			case "empty":	System.out.println(queue.isEmpty());			break;
			}
			
		}
		
		scan.close();
	}

}