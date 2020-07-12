package DataStructures;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueExcercises 
{
	private Stack<Integer> stack = new Stack<Integer>();
	private ArrayQueue queue = new ArrayQueue();
	
	public void add(int item)
	{
		queue.add(item);
	}
	
	public void reverseFirstKthElements(int k)
	{
		for (int i = 0; i < k; i++ )
		{
			stack.push(queue.remove());
		}
		for (int i = 0; i < k;i++)
		{
			queue.add(stack.pop());
		}
	}
	public String toString()
	{
		
		return Arrays.asList(queue).toString();
	}
}