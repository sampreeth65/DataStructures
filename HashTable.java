package DataStructures;

import java.util.LinkedList;

public class HashTable 
{
	private class Entry
	{
		private int key;
		private String value;
		
		public Entry(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
	}
	
	private LinkedList<Entry>[] entries = new java.util.LinkedList[5];
	
	
	public void put(int key,String value)
	{
		int index = hash(key);
		
		if (entries[index] == null)
			entries[index] = new LinkedList<HashTable.Entry>();
		
		
		for (Entry entry : entries[index])
		{
			if (entry.key == key)
			{
				entry.value = value;
				return;
			}
		}
		
		Entry entry = new Entry(key,value);
		entries[index].addLast(entry);
	}
	
	public String get(int key)
	{
		int index = hash(key);
		
		LinkedList<Entry> bucket = entries[index];
		
		if (bucket != null)
		{
			for (Entry entry: bucket)
			{
				if (entry.key == key)
					return entry.value;
			}
		}
		return null;
	}
	
	public void remove(int key)
	{
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		
		if (bucket == null)
			throw new IllegalStateException();
		
		for (Entry entry : bucket)
		{
			if (entry.key == key)
			{
				bucket.remove(entry);
				return;
			}	
		}
		
		throw new IllegalStateException();
	}
	
	
	private int hash(int key)
	{
		return key % entries.length;
	}
}
