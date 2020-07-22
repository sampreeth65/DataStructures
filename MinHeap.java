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
        if (isFull())
            throw new IllegalArgumentException();

        node[count++] = new Node(key, value);

        int currentIndex = count - 1;
        bubbleUp(currentIndex);

    }

    public String remove()
    {
        if (isEmpty())
            throw new IllegalArgumentException();

        String value = node[0].value;
        node[0] = node[--count];

        bubbleDown(0);

        return value;
    }

    private void bubbleDown(int currentIndex)
    {
        if (!isValidParent(currentIndex))
        {
            int lowestIndex = lowestIndex(currentIndex);
            swap(currentIndex,lowestIndex);
            currentIndex = lowestIndex;
        }

        if (currentIndex == currentIndex)
            return;

        bubbleDown(currentIndex);
    }

    private int lowestIndex(int index)
    {
        int lowest = index;
        if (node[leftChildIndex(lowest)].key < node[lowest].key )
            lowest = leftChildIndex(lowest);

        if (node[rightChildIndex(index)].key < node[index].key)
            lowest = rightChildIndex(index);

        return lowest;
    }

    public boolean isFull()
    {
        return count == node.length;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    private void bubbleUp(int currentIndex)
    {
        if (currentIndex == 0)
            return;

        if (node[currentIndex].key < node[parentIndex(currentIndex)].key)
            swap(currentIndex,parentIndex(currentIndex));

        bubbleUp(parentIndex(currentIndex));
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

    private boolean isValidParent(int index)
    {
        if (!(leftChildIndex(index) < node.length) || !(rightChildIndex(index) < node.length))
            return false;

        return node[index].key < node[leftChildIndex(index)].key && node[index].key < node[rightChildIndex(index)].key;
    }

    private int leftChildIndex(int index)
    {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index)
    {
        return (index * 2) + 2;
    }
}
