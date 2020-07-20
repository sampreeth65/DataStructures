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
        swap(0,count);
        list[count--] = 0;
        bubbleDown();
    }

    private void bubbleDown()
    {
        int startIndex = 0;
        while (startIndex != count)
        {
            int maxValue = Math.max(leftChild(startIndex),rightChild(startIndex));
            if (list[leftIndex(startIndex)] == maxValue)
                swap(0,leftIndex(startIndex));
            else
                swap(0,rightIndex(startIndex));

            startIndex++;
        }
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
