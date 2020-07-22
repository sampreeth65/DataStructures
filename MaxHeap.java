package DataStructures;

public class MaxHeap
{
    public static void heapify(int[] array)
    {
        for(int index = 0; index < array.length; index++)
            heapify(array,index);
    }

    private static void heapify(int[] array,int index)
    {

        int largestIndex = index;

        if (largestIndex >= array.length)
            return;

        int leftIndex = largestIndex * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largestIndex])
        {
            swap(array,largestIndex,leftIndex);
            largestIndex = leftIndex;
        }


        int rightIndex = largestIndex * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largestIndex]) {
            swap(array, largestIndex, rightIndex);
            largestIndex = rightIndex;
        }
        heapify(array,largestIndex);
    }

    private static void swap(int[] array,int largestIndex,int leftIndex)
    {
        int temp = array[largestIndex];
        array[largestIndex] = array[leftIndex];
        array[leftIndex] = temp;
    }
}
