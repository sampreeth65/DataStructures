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
		
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("c");
        graph.addEdge("A","B",3);
        graph.addEdge("A","c",10);
        graph.addEdge("B","c",2);
        Path path = graph.getShortestDistance("A","C");
        System.out.println(path);
	}
}