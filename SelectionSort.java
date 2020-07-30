package DataStructures;

public class SelectionSort
{
    public void sort(int[] array)
    {
        for (int index1 = 0; index1 < array.length; index1++)
        {
            int minIndex = index1;
            for (int index2 = index1; index2 < array.length; index2++)
                if (array[index2] < array[minIndex])
                    minIndex = index2;
            swap(array,minIndex,index1);
        }
    }

    private static void swap(int[] array,int firstIndex,int nextIndex)
    {
        int temp = array[firstIndex];
        array[firstIndex] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
