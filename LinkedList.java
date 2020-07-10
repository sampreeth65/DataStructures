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
		if (first == null)
			throw new NoSuchElementException();
		
		if (first == last)
		{
			first = last = null;
			size = 0;
			return;
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
