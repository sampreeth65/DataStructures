package DataStructures;

public class Array 
{
	private int[] items;
	private int count;
	public Array()
	{
		items = new int[3];
	}
	
	public Array(int length)
	{
		items = new int[length];
	}
	
	public void insert(int value)
	{
		if (count == items.length)
		{
			
			int[] newItems = new int[count * 2];

			for (int index = 0; index < count; index++)
			{
				newItems[index] = items[index]; 
			}
			items = newItems;
		}
		
		items[count] = value;
		count++;
	}
	
	public void removeAt(int index)
	{
		if (index < 0 || index >= count)
			throw new IllegalArgumentException();
		
		for (int newIndex = index; newIndex < count; newIndex++)
			items[newIndex] = items[newIndex + 1];
		
		count--;
			
	}
	
	public int indexOf(int value)
	{
		for (int index = 0; index < count; index++)
		{
			if (items[index] == value)
				return index;
		}
		return -1;
	}
	
	public void print()
	{
		for (int index = 0; index < count; index++)
		{
			System.out.println(items[index]);
		}
	}
	
	public int max()
	{
		int maximumValue = 0;
		for (int index = 1;index < count; index++)
		{
			if (items[index] > maximumValue)
				maximumValue = items[index];
		}
		return maximumValue;
	}
}
