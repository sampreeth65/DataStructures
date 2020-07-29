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
        graph.addNode("C");
        graph.addEdge("A","B",3);
        graph.addEdge("B","C",10);
        graph.addEdge("C","A",0);
        //graph.addEdge("B","c",2);
        //Path path = graph.getShortestPath("A","c");
        //System.out.println(path);
        System.out.println(graph.hasCycle());
	}
}