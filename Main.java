package DataStructures;

import java.util.List;
import java.util.Queue;


public class Main {

	public static void reverse(Queue<Integer> queue) {
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		while (!queue.isEmpty())
			stack.push(queue.remove());
		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

	public static void main(String[] args) {


        Graph graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdges("X","A");
        graph.addEdges("X","B");
        graph.addEdges("A","P");
        graph.addEdges("B","P");
        //graph.traverseDepthFirstIterative("r");
        List<String> list = graph.topologicalSorting();
        System.out.println(list);
	}
}