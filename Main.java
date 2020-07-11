package DataStructures;

import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		//System.out.println(list.size());
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		//list.addLast(60);
		//list.addFirst(10);
		list.print();
		list.printMiddleElement();
		//list.removeFirst();
		//System.out.println("Removing first element");
		//System.out.println();
		//list.print();
		//System.out.println("Removing last element");
		//list.removeLast();
		//list.removeLast();
		//list.print();
		//System.out.println(list.indexOf(20));
		// list.indexOf(20);
		//System.out.println(list.size());
		//list.reverse();
		//System.out.println(Arrays.toString(list.toArray()));
		//list.reverse();
		//System.out.println("Printing Kth element: " + list.getKthElementFromTheEnd(6));
	}

}
