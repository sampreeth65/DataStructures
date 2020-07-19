package DataStructures;

public class AVLTree 
{
	private class Node
	{
		private int height;
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
			return "value= " + this.value;
		}
	}
	
	Node root;
	
	public void insert(int value)
	{
		root = insert(root,value);
			
	}
	
	private Node insert(Node root,int value)
	{
		if (root == null)
		{
			return new Node(value);
		}
		
		if (value > root.value)
			root.rightChild = insert(root.rightChild,value);
		else
			root.leftChild = insert(root.leftChild,value);
		
		root.height = Math.max(height(root.leftChild), height(root.rightChild));
		
		int balanceFactor = balanceFactor(root);
		if (isLeftHeavy(root))
			System.out.println("Left heavy");
		else if (isRightHeavy(root))
			System.out.println("Right Heavy");
		
		return root;
	}
	
	private int height(Node node)
	{
		return (node == null) ? -1 : node.height;
	}
	
	private boolean isLeftHeavy(Node node)
	{
		return height(node.leftChild) - height(node.rightChild) > 1;
	}
	
	private boolean isRightHeavy(Node node)
	{
		return height(node.leftChild) - height(node.rightChild) < -1;
	}
	
	private int balanceFactor(Node node)
	{
		return (node == null) ? 0 : (height(node.leftChild) - height(node.rightChild));
	}
	
}
