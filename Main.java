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
		System.out.println(StringUtil.isPalandrome(""));
	}
}