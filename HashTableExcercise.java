package DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableExcercise 
{
	private Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	public char FirstNonRepeatedCharacter(String input)
	{
		for (char character : input.toCharArray())
		{
			if (map.containsKey(character))
				map.put(character, map.get(character) + 1);
			else
				map.put(character, 1);
		}
		System.out.println(map);
		/*
		 * for (Entry<Character, Integer> item: map.entrySet()) { if (item.getValue() ==
		 * 1) return item.getKey(); }
		 */
		return '1';
	}
}
