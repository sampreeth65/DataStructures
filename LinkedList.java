package DataStructures;


public class LinkedList 
{
	private class Node
	{
		private int value;
		private Node next;
		
		public Node(int newValue)
		{
			value = newValue;
		}
	}
	private Node first;
	private Node last;
	
	//addFirst
	public void addFirst(int item)
	{
		Node node = new Node(item);
		
		if (first == null)
			first = last = node;
		else
		{
			node.next = first;
			first = node;
		}
	}
	
	
	//addLast
	public void addLast(int item)
	{
		Node node = new Node(item);
		
		if (first == null)
		{
			first = node;
			last = node;
		}
		else
		{
			last.next = node;
			last = node;
		}	
	}
	
	//deleteFirst
	//deleteLast
	//contains
	public boolean contains(int item)
	{
		return indexOf(item) != -1;
	}
	
	//indexOf
	public int indexOf(int item)
	{
		int index = 0;
		Node currentNode = first;
		
		while(currentNode != null)
		{
			if (currentNode.value == item)
				return index;
			currentNode = currentNode.next;
			index++;
		}
		return -1;
	}
}
