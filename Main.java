package DataStructures;

import java.util.Arrays;
import java.util.List;
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
	    int[] array = {15,6,3,1,22,10,13};
        QuickSort quick = new QuickSort();
        quick.sort(array);
        System.out.println(Arrays.toString(array));

	}
}