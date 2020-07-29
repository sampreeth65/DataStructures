package DataStructures;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Stack;

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

    private class NodeEntry
    {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    /**
     * Dijkstra's shortest path algorithm
     * @param from
     * @param to
     * @return
     */
    public Path getShortestPath(String from,String to)
    {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        Map<Node,Integer> distance = new HashMap<>();
        for (Node node :nodes.values())
            distance.put(node,Integer.MAX_VALUE);
        distance.replace(fromNode,0);

        Set<Node> visited = new HashSet<>();

        Map<Node,Node> previousNode = new HashMap<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode,0));

        while (!queue.isEmpty())
        {
            Node current = queue.remove().node;
            visited.add(current);

            for (Edge edge : current.getEdge())
            {
                if (visited.contains(edge.to))  // this one is still unsure.
                    continue;

                int newDistance = distance.get(current) + edge.weight;
                if (newDistance < distance.get(edge.to))
                {
                    distance.replace(edge.to,newDistance);
                    previousNode.put(edge.to,current);
                    queue.add(new NodeEntry(edge.to,newDistance));
                }
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous = previousNode.get(toNode);
        while (previous != null)
        {
            stack.push(previous);
            previous = previousNode.get(previous);
        }

        System.out.println(stack.pop());
        Path path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    public boolean hasCycle()
    {
        Set<Node> visited = new HashSet<>();

        for(Node node: nodes.values())
        {
            if (!visited.contains(node))
            {
                if (hasCycle(node,null,visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node ,Node parent,Set<Node> visited)
    {
        visited.add(node);

        for (Edge edge : node.getEdge())
        {
            if (edge.to == parent)
                 continue;
            if (visited.contains(edge.to))
                return true;

            if (hasCycle(edge.to,node,visited))
                return true;
        }
        return false;
    }

}
