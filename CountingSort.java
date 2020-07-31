package DataStructures;

import java.util.Arrays;

public class CountingSort
{
    public void sort(int[] array)
    {
        int maxValue = 0;
        for (int value : array)
        {
            if (value > maxValue)
                maxValue = value;
        }

        int[] numberOfIteration = new int[maxValue + 1];

        for (int i = 0; i < array.length; i++)
        {
            numberOfIteration[array[i]]++;
        }

        int indexOfarray = 0;
        for (int i = 0; i < numberOfIteration.length; i++)
        {
            if (numberOfIteration[i] >= 1)
            {
                for (int j = 0; j < numberOfIteration[i];j++)
                {
                    array[indexOfarray++] = i;
                }
            }
        }
    }
}
