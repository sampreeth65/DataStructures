package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//import javax.sound.sampled.ReverbType;

public class Main {

	public static void reverse(Queue<Integer> queue) {
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		while (!queue.isEmpty())
			stack.push(queue.remove());
		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

	public static void main(String[] args) {
		/*
		 * ArrayQueue queue = new ArrayQueue(); queue.add(10); queue.add(20);
		 * queue.add(30); queue.add(40); queue.add(50); //queue.add(60);
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * System.out.println(queue.remove()); System.out.println(queue);
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * System.out.println(queue.remove());
		 * 
		 * 
		 * //System.out.println(queue.remove());
		 * 
		 * queue.add(30); queue.add(70); System.out.println(queue); queue.add(34);
		 */

		/*
		 * QueueUsingStack queue = new QueueUsingStack();
		 * 
		 * 
		 * queue.add(10); queue.add(20);
		 * 
		 * System.out.println(queue); System.out.println(queue.remove());
		 */

		/*
		 * QueueExcercises queue = new QueueExcercises(); queue.add(10); queue.add(20);
		 * queue.add(30); queue.add(40); queue.add(50);
		 * queue.reverseFirstKthElements(3); System.out.println(queue);
		 */

		/*
		 * HashTableExcercise mapping = new HashTableExcercise(); char ch =
		 * mapping.FirstNonRepeatedCharacter("Hello"); System.out.println(ch);
		 * 
		 * char ch1 = mapping.firstRepeatedCharacter("Hello"); System.out.println(ch1);
		 */

		/*
		 * HashTable table = new HashTable();
		 * 
		 * table.put(2, "Hello"); table.put(10, "world"); table.put(7,
		 * "Collision checking"); System.out.println(table.get(7));
		 */

		/*
		 * HashTableExcercise map = new HashTableExcercise(); int[] array =
		 * {1,2,3,4,2,1,5,3,2,4,3,2,2,2}; System.out.println(map.mostFrequent(array));
		 */

		/*
		 * Tree tree = new Tree();
		 * 
		 * 
		 * tree.insert(20);
		 * 
		 * 
		 * tree.insert(10); tree.insert(30); tree.insert(26); tree.insert(24);
		 * tree.insert(6); tree.insert(14); tree.insert(3); tree.insert(8);
		 */
		 

		/*
		 * Tree tree2 = new Tree();
		 * 
		 * 
		 * tree2.insert(20); tree2.insert(10); tree2.insert(30); tree2.insert(26);
		 * tree2.insert(24); tree2.insert(6); tree2.insert(14); tree2.insert(3);
		 * //tree2.insert(8);
		 */

		// System.out.println(tree.find(3));

		// System.out.println("hello");
		// tree.traversalPreOrder();
		// tree.traversalInOrder();
		// tree.traversalPostOrder();
		// System.out.println(tree.height());
		// System.out.println(tree.minBST());
		// System.out.println(tree.equals(tree2));
		// tree.kthElements(3);
		//System.out.println(tree.size());
		//System.out.println(tree.countLeaves());
		//System.out.println(tree.max());
		//System.out.println(tree.contains(11));
		/*
		AVLTree tree = new AVLTree();

		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		//tree.insert(40);

*/
		/*Heap heap = new Heap();
		heap.insert(20);
		heap.insert(10);
		heap.insert(3);
		heap.insert(1);
		heap.insert(5);
		heap.insert(11);
		heap.insert(32);
		System.out.println(heap);
		heap.remove();
		System.out.println(heap);*/

        /*int[] array = {5,3,4,2,1};
        //MaxHeap.heapify(array);
        //System.out.println(Arrays.toString(array));
        System.out.println(MaxHeap.isMaxHeap(array));*/

		/*System.out.println("done");*/

		/*MinHeap heap = new MinHeap(10);
		heap.insert(10,"World");
		heap.insert(1,"Hello");
		heap.insert(5,"Java");
		heap.insert(6,"sampreeth");
		heap.insert(7,"Mad");
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());

		System.out.println();*/

		Trie trie = new Trie();
		//trie.insert("cat");
		trie.insert("canada");
		trie.insert("can");
		trie.insert("cat");
		trie.insert("tiger");
		trie.insert("careful");
		trie.insert("care");
		trie.insert("car");
		//System.out.println(trie.contains(""));
        //trie.traverse();
		//trie.remove("canada");
		//System.out.println(trie.contains("canada"));
		var words = trie.findWord(null);
		System.out.println(words);
	}
}