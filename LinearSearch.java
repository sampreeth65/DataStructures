package DataStructures;

public class LinearSearch
{
    public boolean search(int[] array,int value)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == value)
                return true;
        }
        return false;
    }
}
