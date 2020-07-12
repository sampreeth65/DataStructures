package DataStructures;

import java.util.ArrayDeque;
import java.util.Queue;

//import javax.sound.sampled.ReverbType;

public class Main {

	public static void reverse(Queue<Integer> queue) {
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		while (!queue.isEmpty())
			stack.push(queue.remove());
		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

	public static void main(String[] args) {
		/*
		 * ArrayQueue queue = new ArrayQueue(); queue.add(10); queue.add(20);
		 * queue.add(30); queue.add(40); queue.add(50); //queue.add(60);
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * System.out.println(queue.remove()); System.out.println(queue);
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * 
		 * //System.out.println(queue.remove());
		 * 
		 * queue.add(30); queue.add(70); System.out.println(queue); queue.add(34);
		 */

		/*
		 * QueueUsingStack queue = new QueueUsingStack();
		 * 
		 * 
		 * queue.add(10); queue.add(20);
		 * 
		 * System.out.println(queue); System.out.println(queue.remove());
		 */
		
		PriorityQueue queue = new PriorityQueue();
		queue.add(10);
		queue.add(2);
		queue.add(5);
		queue.add(1);
		System.out.println(queue);
	}

}
