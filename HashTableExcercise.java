package DataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableExcercise 
{
	private Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	public char FirstNonRepeatedCharacter(String input)
	{
		for (char character : input.toCharArray())
		{
			int count = map.containsKey(character) ? map.get(character) : 0;
			map.put(character, count + 1);
		}
		
		for (char character : input.toCharArray())
		{
			if (map.get(character) == 1)
				return character;
		}
		
		//System.out.println(map);
		/*
		 * for (Entry<Character, Integer> item: map.entrySet()) { if (item.getValue() ==
		 * 1) return item.getKey(); }
		 */
		return Character.MIN_VALUE;
	}
	
	public char firstRepeatedCharacter(String input)
	{
		Set<Character> set = new HashSet<Character>();
		
		for (char character: input.toCharArray())
		{
			if(set.contains(character))
				return character;
			set.add(character);
		}
		return Character.MIN_VALUE;
		
	}
	
	public int mostFrequent(int[] array)
	{
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		//Set<Integer> set = new HashSet<Integer>();
		
		
		for (int ar : array)
		{
			int count = map1.containsKey(ar) ? map1.get(ar) : 0;
			map1.put(ar, count + 1);
			//set.add(ar);
		}
		
		int highest = -1;
		int result = array[0];
		
		for (int ar : array)
		{
			if (map1.get(ar) > highest)
			{
				highest = map1.get(ar);
				result = ar;
			}
		}
		
		/*
		 * for (int ar : array) { if (map1.get(ar) == highest) return ar; }
		 */
		return result;
	}
}
