package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList 
{
	private class Node
	{
		private int value;
		private Node next;
		
		public Node()
		{
			
		}
		public Node(int newValue)
		{
			value = newValue;
		}
	}
	
	
	private Node first;
	private Node last;
	private int size;
	
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
		
		size++;
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
		size++;
	}
	
	//deleteFirst
	public void removeFirst()
	{
		if (first == null)
			throw new NoSuchElementException();
		
		if (first == last)
		{
			first = last = null;
			size = 0;
			return;
		}
		Node second = first.next;
		first = null;
		first = second;
		
		size--;
	}
	
	//deleteLast
	public void removeLast()
	{
		if (first == null)    // if list is empty and tried to remove a value, it will throw NullPointerException
			throw new NoSuchElementException();  // So to handle this we will throw NoSuchElementException
		
		if (first == last)
		{
			first = last = null;
			size = 0;
			return;     // If list is empty first and last element will be the same node and there is no need to traverse the list.
		}
		Node currentNode = first;
		
		while(currentNode.next != last)
		{
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		last = currentNode;
		
		size--;
	}
	
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
	
	public void print()
	{
		if (first == last)
		{
			System.out.println(first.value);
			return;
		}
		
		Node currentNode = first;
		
		while(currentNode != null)
		{
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	//Counting through the list will increase the time complexity to o(n)
	// using this process to find the size of the list will make time complexity to o(1)
	public int size()
	{
		return size;	
	}
	
	public int[] toArray()
	{
		int[] array = new int[size];
		int index = 0;
		
		Node currentNode = first;
		while(currentNode != null)
		{
			array[index++] = currentNode.value;
			currentNode = currentNode.next;
		}
		
		return array;
	}
	
	/**
	 * This method is not needed to be handled by the users therefore it is private.
	 * @param node
	 * @return
	 */
	private Node previousNode(Node node)
	{
		Node currentNode = first;
		//Node previousNode;
		while (currentNode.next != node)
		{
			currentNode = currentNode.next;
		}
		return currentNode;
	}
	
	public void reverse()
	{
		//Example: [10  ->  20 -> 30]
		//          p   <-  c      n
		//                  p  <-  c  <- n
		
		if (first == null) 
			return;
		
		Node previous = first;
		Node currentNode = first.next;
		while (currentNode != null)
		{
			Node next = currentNode.next;
			currentNode.next = previous;
			previous = currentNode;
			currentNode = next;
		}
		last = first;
		last.next = null;
		first = previous;
	}
	
	//Time complexity of this process o(n) this process takes more time than above process.
	public void reverse_try()
	{
		Node currentNode = last;
		while (currentNode != first)
		{
			Node previous = previousNode(currentNode);
			currentNode.next = previous;
			currentNode = previous;
		}
		first.next = null;
		Node tempNode;
		tempNode = last;
		last = first;
		first = tempNode;
	
		
	}
}
