package DataStructures;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort
{
    public void sort(int[] array,int numberOfBucket)
    {
        int i = 0;
        for (var bucket :createBucket(array,numberOfBucket))
        {
            Collections.sort(bucket);
            for (var item: bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBucket(int[] array, int numberOfBucket)
    {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBucket;i++)
        {
            buckets.add(new ArrayList<>());
        }

        for (int value: array)
        {
            buckets.get(value/numberOfBucket).add(value);
        }
        return buckets;
    }
}
