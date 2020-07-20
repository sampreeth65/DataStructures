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
		
		root.height = maxHeight(root);
		
		root = balance(root);

		return root;
	}

	private Node balance(Node root)
	{
		if (isLeftHeavy(root))
		{
			if (balanceFactor(root.leftChild) < 0)
				root.leftChild = leftRotate(root.leftChild);
			root = rightRotate(root);
		}
		else if (isRightHeavy(root))
		{
			if (balanceFactor(root.rightChild) > 0)
				root.rightChild = rightRotate(root.rightChild);
			root = leftRotate(root);
		}
		return root;
	}
	
	private int height(Node node)
	{
		return (node == null) ? -1 : node.height;
	}
	
	private boolean isLeftHeavy(Node node)
	{
		return (balanceFactor(node) > 1);
	}
	
	private boolean isRightHeavy(Node node)
	{
		return (balanceFactor(node) < -1);
	}
	
	private int balanceFactor(Node node)
	{
		return (node == null) ? 0 : (height(node.leftChild) - height(node.rightChild));
	}

	private Node leftRotate(Node root)
	{
		Node newRoot = root.rightChild;
		root.rightChild = newRoot.leftChild;
		newRoot.leftChild = root;
		maxHeight(newRoot);
		maxHeight(root);


		return newRoot;
	}

	private int maxHeight(Node node)
	{
		return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
	}

	private Node rightRotate(Node root)
	{
		Node newRoot = root.leftChild;
		root.leftChild = newRoot.leftChild;
		newRoot.rightChild = root;
		maxHeight(root);
		maxHeight(newRoot);

		return newRoot;
	}
}
