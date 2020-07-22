package DataStructures;

public class MinHeap
{
    private class Node
    {
        private int key;
        private String value;

        public Node(int key,String value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] node;
    private int count;

    public MinHeap(int capacity)
    {
        node = new Node[capacity];
    }

    public void insert(int key, String value)
    {
        if (count == node.length)
        {
            for (int index = 0; index < node.length; index++)
            {
                if (node[index].key == key)
                    node[index].value = value;
            }
            return;
        }

        if (node[count] == null)
        {
            node[count] = new Node(key, value);
            count++;
        }

        int currentIndex = count - 1;
        bubbleDown(currentIndex);

    }

    private void bubbleDown(int currentIndex)
    {
        if (currentIndex == 0)
            return;

        if (node[currentIndex].key < node[parentIndex(currentIndex)].key)
            swap(currentIndex,parentIndex(currentIndex));

        bubbleDown(parentIndex(currentIndex));
    }

    private int parentIndex(int index)
    {
        return (index - 1) / 2;
    }

    private void swap(int firstIndex,int secondIndex)
    {
        Node temp = node[firstIndex];
        node[firstIndex] = node[secondIndex];
        node[secondIndex] = temp;
    }
}
