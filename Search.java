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

        return binarySearchRec(array,value,0,array.length);
    }

    private int binarySearchRec(int[] array,int value,int start,int end)
    {
        int middle = (start + end)/2;

        if (array.length == 1)
            return - 1;

        if (array[middle] > value)
            binarySearchRec(array, value, start, middle - 1);
        else if (array[middle] < value)
            binarySearchRec(array, value, middle + 1, end);


        return middle;
    }

    public int binarySearchIte(int[] array,int value)
    {
        Arrays.sort(array);

        int middle = array.length/2;
        

    }

    private int binaraySearchIte(int[] array,int value,int start,int end)
    {

    }

}
