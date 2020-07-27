package DataStructures;

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
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdges("A","B");
        graph.addEdges("B","D");
        graph.addEdges("D","C");
        graph.addEdges("A","C");
        graph.traverseDepthFirstIterative("r");
	}
}