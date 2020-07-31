package DataStructures;

import java.util.Arrays;

public class Search
{
    public int linearSearch(int[] array,int value)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public int binarySearchRec(int[] array, int value)
    {
        Arrays.sort(array);

        return binarySearchRec(array,value,0,array.length - 1);
    }

    private int binarySearchRec(int[] array,int value,int start,int end)
    {
        if (end < start)
            return -1;

        int middle = (start + end)/2;

        if (array[middle] == value)
            return middle;

        if (array[middle] > value)
            binarySearchRec(array, value, start, middle - 1);
        return binarySearchRec(array, value, middle + 1, end);

    }

    public int binarySearchIte(int[] array,int value)
    {
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left <= right)
        {
            int middle = (left + right)/2;

            if (array[middle] == value)
                return middle;

            if (array[middle] > value)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }

    public int ternarySearch(int[] array,int value)
    {
        Arrays.sort(array);
        return  ternarySearch(array, value,0,array.length - 1);

    }

    private int ternarySearch(int[] array,int value,int start,int end)
    {
        if (end <= start)
            return -1;

        int partitionSize = (end - start)/3;
        int mid1 = start + partitionSize;
        int mid2 = end - partitionSize;

        if (value > array[mid2])
            return ternarySearch(array, value, mid2 + 1, end);
        else if (value == array[mid2])
            return mid2;
        else if (value > array[mid1] && value < array[mid2])
            return ternarySearch(array,value,mid1 + 1,mid2 - 1);
        else if (value == array[mid1])
            return mid1;

        return ternarySearch(array,value,start,mid1 - 1);
    }

    public int jumpSearch(int[] array,int value)
    {
        int blockSize = (int) Math.sqrt(array.length);

        int start = 0;
        int next = blockSize + 1;

        while (start < array.length)
        {
            if (value > array[next - 1])
            {
                start = next;
                next = next + blockSize;
                if (next > (array.length))
                    next = array.length;
                continue;
            }
            for (int i = start; i < next;i++)
            {
                if (value == array[i])
                    return i;
            }
            return -1;
        }
        return -1;
    }

    public int exponentialSearch(int[] array, int value)
    {
        int bound = 1;
        while (bound < array.length && (value > array[bound]))
            bound *= 2;
        return binarySearchRec(array,value,bound/2,Math.min(bound,array.length -1 ));
    }


}
