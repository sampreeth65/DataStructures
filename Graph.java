package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph
{
    private class Node
    {
        String label;

        public Node(String label)
        {
            this.label = label;
        }

        @Override
        public String toString()
        {
            return label;
        }
    }

    private Map<String,Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyNode = new HashMap<>();

    public void addNode(String label)
    {
        Node node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyNode.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdges(String from,String to)
    {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyNode.get(fromNode).add(toNode);
    }

    public void print()
    {
        for (Node source : adjacencyNode.keySet())
        {
            List<Node> target = adjacencyNode.get(source);
            if (!target.isEmpty())
                System.out.println(source + " is connected to " + target);
        }
    }

    public void remove(String label)
    {
        Node node = nodes.get(label);
        if (node == null)
            return;

        for (Node node1 :adjacencyNode.keySet())
            adjacencyNode.get(node1).remove(node);

        adjacencyNode.remove(node);
        nodes.remove(label);
    }

    public void removeEdges(String from, String to)
    {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            return;

        Node toNode = nodes.get(to);
        if (toNode == null)
            return;

        adjacencyNode.get(fromNode).remove(toNode);

    }
}
