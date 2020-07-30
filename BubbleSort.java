package DataStructures;

public class BubbleSort
{
    public static int[] sort(int[] array)
    {
        int length = array.length;

        for (int initialIndex = 0; initialIndex < length ; initialIndex++)
        {
            for (int index = 1; index < length; index++)
            {
                if (array[index] < array[index - 1])
                    swap(array,index,index - 1);
            }
        }
        return array;
    }

    private static void swap(int[] array,int firstIndex,int nextIndex)
    {
        int temp = array[firstIndex];
        array[firstIndex] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
