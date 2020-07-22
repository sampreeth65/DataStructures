package DataStructures;

public class MaxHeap
{
    public static void heapify(int[] array)
    {
        for(int index = 0; index < array.length; index++) {
            heapify(array, index);
        }
    }

    private static void heapify(int[] array,int index)
    {
        int largestIndex = index;

        int leftIndex = largestIndex * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largestIndex])
        {
            swap(array,largestIndex,leftIndex);
            largestIndex = leftIndex;
        }


        int rightIndex = largestIndex * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largestIndex])
        {
            swap(array, largestIndex, rightIndex);
            largestIndex = rightIndex;
        }

        if (largestIndex == index)
            return;

        heapify(array,largestIndex);
    }

    private static void swap(int[] array,int largestIndex,int leftIndex)
    {
        int temp = array[largestIndex];
        array[largestIndex] = array[leftIndex];
        array[leftIndex] = temp;
    }

    public static boolean isMaxHeap(int[] array)
    {
        // leftChild > parent
        // rightChild > parent

        for (int index = 0; index < array.length; index++)
        {
            if (leftChildIndex(index) < array.length && rightChildIndex(index) < array.length)
                if (!(array[index] > array[leftChildIndex(index)] && array[index] > array[rightChildIndex(index)]))
                    return false;
        }
        return true;
    }

    private static int leftChildIndex(int index)
    {
        return (index * 2) + 1;
    }

    private static int rightChildIndex(int index)
    {
        return (index * 2) + 2;
    }
}
