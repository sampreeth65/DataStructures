package DataStructures;

import java.util.Queue;


public class Main {

	public static void reverse(Queue<Integer> queue) {
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		while (!queue.isEmpty())
			stack.push(queue.remove());
		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

	public static void main(String[] args)
	{
	    int[] array = {15,6,3,1,12,12,22,10,13};
       	var serach = new Search();
		System.out.println(serach.binarySearchRec(array,3));
	}
}