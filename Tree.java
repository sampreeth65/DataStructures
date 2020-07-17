package DataStructures;

public class Tree 
{
	private class Node
	{
		private int value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int value)
		{
			this.value = value;
		}
		
		@Override
		public String toString()
		{
			return "Node=" + value;
		}
	}
	
	Node root;
	
	public void insert(int value)
	{
		Node node = new Node(value);
		
		if (root == null)
		{
			root = node;
			return;
		}
		
		
		Node currentNode = root;
		while (true)
		{
			if (value > currentNode.value)
			{
				if (currentNode.rightChild == null)
				{
					currentNode.rightChild = node;
					break;
				}
				currentNode = currentNode.rightChild;
			}
				
			else
			{
				if (currentNode.leftChild == null)
				{
					currentNode.leftChild = node;
					break;
				}
				currentNode = currentNode.leftChild;
			}
				
		}
	}
	
	public boolean find(int value)
	{
		if (root == null)
			throw new IllegalStateException();
		
		Node currentNode = root;
		while (currentNode != null)
		{
			if (currentNode.value == value)
				return true;
			
			if (currentNode.value < value)
				currentNode = currentNode.rightChild;
			else
				currentNode = currentNode.leftChild;
		}
		return false;
	}
	
	public void traversalPreOrder()
	{
		traversalPreOrder(root);
	}
	
	private void traversalPreOrder(Node root)
	{
		if (root == null)
			return;
		
		System.out.println(root.value);
		traversalPreOrder(root.leftChild);
		traversalPreOrder(root.rightChild);
	}
}
