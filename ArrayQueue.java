package DataStructures;

import java.util.Arrays;
import java.util.Stack;

public class ArrayQueue {
	private int[] items;
	private int count;
	private int forward;
	private int rear;
	
	public ArrayQueue() {
		items = new int[5];
		forward = rear = 0;
	}

	// enqueue
	public void add(int item) {
		if (count == items.length)
			throw new IllegalStateException();

		items[rear] = item;
		rear = (rear + 1) % items.length;
		count++;
	}

	// dequeue
	public int remove() {
		if (count == 0)
			throw new IllegalArgumentException();

		int item = items[forward]; 
		items[forward] = 0;
		forward = (forward + 1) % items.length;
		count--;
		return item;
	}

	public boolean isEmpty() {
		return forward == rear;
	}

	public boolean isFull() {
		return rear == items.length;
	}

	public int peek() {
		return items[forward];
	}

	@Override
	public String toString()
	{
		return Arrays.toString(items);
	}
	
	

}
