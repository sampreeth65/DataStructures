package DataStructures;

import java.util.Arrays;

public class PriorityQueue 
{
	private int[] items = new int[5];
	private int count;
	
	public void add(int item)
	{
		if (count == items.length)
			throw new IllegalStateException();
		shiftElements(item);
	}
	
	/**
	 * removing based on largest number in the queue.
	 * @return 
	 */
	public int remove()
	{
		if (isEmpty())
			throw new IllegalStateException();
		
		return items[--count];
	}
	
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	public void shiftElements(int item)
	{
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
	
	@Override
	public String toString() {
		return Arrays.toString(items);
	}
}
