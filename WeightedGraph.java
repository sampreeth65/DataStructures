package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph
{
    private class Node
    {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label)
        {
            this.label = label;
        }

        @Override
        public String toString()
        {
            return "Value = " + label;
        }

        public void addEdge(Node to,int weight)
        {
            edges.add(new Edge(this,to,weight));
        }

        public List<Edge> getEdge()
        {
            return edges;
        }
    }

    private class Edge
    {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight)
        {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString()
        {
            return from + "->" + to;
        }
    }

    private Map<String,Node> nodes = new HashMap<>();

    public void addNode(String label)
    {
        if (!nodes.containsKey(label))
            nodes.put(label,new Node(label));
    }

    public void addEdge(String from, String to, int weight)
    {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode,weight);
        toNode.addEdge(fromNode,weight);
    }

    public void print()
    {
        for (Node node : nodes.values())
        {
            List<Edge> edges = node.getEdge();
            if (!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

}