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
	
	private Node root;
	
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
		System.out.println("Printing in Tree Traversal Pre-Order");
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
	
	public void traversalInOrder()
	{
		System.out.println("Printing in Tree Traversal In-Order");
		traversalInOrder(root);
	}
	
	private void traversalInOrder(Node root)
	{
		if (root== null)
			return;
		
		traversalInOrder(root.leftChild);
		System.out.println(root.value);
		traversalInOrder(root.rightChild);
		
	}
	
	public void traversalPostOrder()
	{
		System.out.println("Printing in traversal Post - Order");
		traversalPostOrder(root);
	}
	
	private void traversalPostOrder(Node root)
	{
		if (root == null)
			return;
		
		traversalPostOrder(root.leftChild);
		traversalPostOrder(root.rightChild);
		System.out.println(root.value);
	}
	
	public int height() 
	{
		return height(root);
	}
	
	private int height(Node root)
	{
		if (root == null)
			return -1;
		
		
		if (isLeaf(root))
			return 0;
		
		return 1 + Math.max(height(root.leftChild),height(root.rightChild));
	}
	
	private boolean isLeaf(Node root)
	{
		return root.leftChild == null && root.rightChild == null;
	}
	
	//O(log n)
	public int minBST()
	{
		return minBST(root);
	}
	
	private int minBST(Node root)
	{
		if (root == null)
			throw new IllegalStateException();
		
		
		Node current = root;
		Node last = current;
		
		while(current != null)
		{
			last = current;
			current = current.leftChild;
		}
		
		return last.value;
	}
	
	/**
	 * This implementation is for binary tree
	 * O(n)
	 * @return int 
	 */
	public int min()
	{
		return min(root);
	}
	
	private int min(Node root)
	{
		if (isLeaf(root))
			return root.value;
		
		int left = min(root.leftChild);
		int right = min(root.rightChild);
		
		return Math.min(root.value,Math.min(left, right));
	}
	public Node getRoot()
	{
		return root;
	}
	
	public boolean equals(Tree otherTree)
	{
		if (otherTree == null)
			return false;
			
		return equals(root,otherTree.getRoot());
	}
	
	private boolean equals(Node first,Node second)
	{
		if (first == null && second == null)
			return true;
		
		if (first != null && second != null)
			return first.value == second.value 
				&& equals(first.leftChild,second.leftChild)
				&& equals(first.rightChild,second.rightChild);
		
		return false;
	}
	
	public boolean validateBST()
	{
		if (root == null)
			throw new IllegalStateException();
		
		return validateBST(root);
		
	}
	
	private boolean validateBST(Node root)
	{
		if (isLeaf(root))
			return true;
		
		Node left = root.leftChild;
		Node right = root.rightChild;
		
		return left.value < root.value 
				&& right.value > root.value
				&& validateBST(left) 
				&& validateBST(right);		
	}
	
	public void kthElements(int distance)
	{
		kthElements(root,distance);
	}
	
	private void kthElements(Node root,int distance)
	{
		if (root == null)
			return;
		
		if (distance == 0)
		{
			System.out.println(root.value);
			return;
		}
		
		kthElements(root.leftChild,distance - 1);
		kthElements(root.rightChild,distance - 1);
	}
	
	
	
	public int size()
	{
		int size = 0;
		
		return size(root,size);
	}
	
	private int size(Node root,int size)
	{
		if (root != null)
		{
			size++;
			size = size(root.leftChild,size);
			size = size(root.rightChild,size);
		}
		
		return size;
	}
	
	public int countLeaves() 
	{
		int countLeaves = 0;
		
		return countLeaves(root,countLeaves);
	}
	
	private int countLeaves(Node root,int countLeaves)
	{
		if (root == null)
			return countLeaves;
		
		if (isLeaf(root))
			countLeaves++;
		
		
		countLeaves = countLeaves(root.leftChild,countLeaves);
		countLeaves = countLeaves(root.rightChild,countLeaves);
		
		return countLeaves;
	}
	
	public int max()
	{
		return max(root);
	}
	
	private int max(Node root)
	{
		if (root == null)
			throw new IllegalStateException();
		
		if (root.rightChild == null)
			return root.value;
		
		return max(root.rightChild);
	}
	
	public boolean contains(int value)
	{
		return contains(root,value);
	}
	
	private boolean contains(Node root, int value)
	{	
		if (root == null)
			return false;
		
		if (root.value == value)
			return true;
		
		
		return	contains(root.leftChild,value) || contains(root.rightChild,value);
	}
	
}
