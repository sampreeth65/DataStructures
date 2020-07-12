package DataStructures;

public class Stack 
{
	private char[] list = new char[3];
	private int count;
	
	//push
	public void push(char input)
	{
		if (isFull())
			throw new StackOverflowError();
		
		list[count++] = input;
			
	}
	
	public char pop()
	{
		if (isEmpty())
			throw new IllegalStateException();
		
		return list[--count];
	}
	
	public char peek()
	{
		if (isEmpty())
			throw new IllegalArgumentException();
		return list[count - 1];
	}
	
	private boolean isFull()
	{
		return count == list.length;
	}
	
	public boolean isEmpty()
	{
		return count == 0;
	}
	
}
