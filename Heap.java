package DataStructures;

import java.util.Arrays;

public class Heap
{
    private int[] list;
    private int count;

    public Heap()
    {
        list = new int[20];
        count = 0;
    }

    public Heap(int capacity)
    {
        list = new int[capacity];
        count = 0;
    }

    public void insert(int value)
    {
        if (isFull())
            throw new IllegalStateException();

        list[count++] = value;
        bubbleUp();
    }

    public boolean isFull()
    {
        return count == list.length;
    }

    public void remove()
    {
        if (count == 0)
            throw new IllegalStateException();

        list[0] = list[--count];

        bubbleDown();
    }

    private void bubbleDown()
    {
        int startIndex = 0;
        while (startIndex <= count && !isValidParent(startIndex))
        {
            int maxValue = largestChildIndex(startIndex);

            swap(startIndex,maxValue);
            startIndex = maxValue

        }
    }

    private int largestChildIndex(int index)
    {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftIndex(index);

        return leftChild(index) > rightChild(index) ? leftChild(index) : rightChild(index);
    }

    private boolean hasLeftChild(int index)
    {
        return leftIndex(index) <= count;
    }

    private boolean hasRightChild(int index)
    {
        return rightIndex(index) <= count;
    }


    private boolean isValidParent(int index)
    {
        if (!hasLeftChild(index))
            return true;

        if (!hasRightChild(index))
            return list[index] >= leftChild(index);

        return list[index] >= leftChild(index) &&
                list[index] >= rightChild(index);
    }

    private int leftChild(int currentIndex)
    {
        return list[leftIndex(currentIndex)];
    }

    private int rightChild(int currentIndex)
    {
        return list[rightIndex(currentIndex)];
    }

    private int leftIndex(int currentIndex)
    {
        return (currentIndex * 2) + 1;
    }

    private int rightIndex(int currentIndex)
    {
        return (currentIndex * 2) + 2;
    }

    private int parentIndex(int currentIndex)
    {
        return (currentIndex - 1) / 2;
    }

    private void bubbleUp()
    {
        int currentIndex = count - 1;
        while(currentIndex > 0 && (list[currentIndex] > list[parentIndex(currentIndex)]))
        {
            swap(currentIndex,parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }

    private void swap(int first,int second)
    {
        int temp = list[second];
        list[second] = list[first];
        list[first] = temp;
    }

  

    @Override
    public String toString()
    {
        return Arrays.toString(list);
    }
}
