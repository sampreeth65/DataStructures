package DataStructures;

import java.util.Arrays;

public class PriorityQueue 
{
	//private Array ar = new Array(10);
	
	private int[] items = new int[5];
	private int count;
	
	public void add(int item)
	{
		if (count == items.length)
			throw new IllegalStateException();
		
		int i;
		for (i = count; i>= 0; i--)
		{
			if (items[i] > item)
				items[i + 1] = items[i];
			else 
				break;
		}
		items[i + 1] = item;
		count++;
	}
	
	/**
	 * removing based on largest number in the queue.
	 * @return 
	 */
	public int remove()
	{
		if (count == 0)
			throw new IllegalStateException();
		
		return items[--count];
	}
	
	
	@Override
	public String toString() {
		return Arrays.toString(items);
	}
}
