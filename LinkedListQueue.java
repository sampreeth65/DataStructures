package DataStructures;

public class LinkedListQueue 
{
	public class Node
	{
		private int value;
		private Node next;
		
		public Node(int value)
		{
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	private int count;
	
	public void add(int item)
	{
		Node node = new Node(item);
		
		if (first == null)
			last = first = node;
		else
		{
			last.next = node;
			last = node;
		}
		count++;
	}
	
	public int remove()
	{
		if (isEmpty())
			throw new IllegalStateException();
		
		int item = first.value;
		first = first.next;
		count--;
		return item;
	}
	
	public int peek()
	{
		if (isEmpty())
			throw new IllegalStateException();
		
		return first.value; 
	}
	
	public void print() 
	{
		Node currentNode = first;
		while(currentNode != null)
		{
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
}
