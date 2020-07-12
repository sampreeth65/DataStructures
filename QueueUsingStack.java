package DataStructures;

import java.util.Arrays;
import java.util.Stack;

public class QueueUsingStack 
{
	private	Stack<Integer> stack1 = new Stack<Integer>();
	private	Stack<Integer> stack2 = new Stack<Integer>();
	
	public void add(int item)
	{
		stack1.push(item);
	}
	
	public int remove()
	{
		if (stack1.isEmpty() && stack2.isEmpty())
			throw new IllegalArgumentException();
		
		if (stack2.isEmpty())
		{
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	@Override
	public String toString()
	{
		return Arrays.asList(stack1).toString();
	}
}
