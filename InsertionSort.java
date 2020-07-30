package DataStructures;

public class InsertionSort
{
    public void sort(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int curretIndex = i;
            int current = array[curretIndex];
            while ((curretIndex != 0) && (current < array[curretIndex - 1]))
            {
                array[curretIndex] = array[curretIndex - 1];
                curretIndex = curretIndex - 1;
            }
            array[curretIndex] = current;
        }
    }
}
