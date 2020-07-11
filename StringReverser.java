package DataStructures;

import java.util.Stack;

public class StringReverser 
{
	public String reverse(String str)
	{
		if (str == null)
			throw new IllegalArgumentException();
		
		Stack<Character> stack = new Stack<Character>();
		
		for (char ch : str.toCharArray())
			stack.push(ch);
		
		StringBuffer reverseString = new StringBuffer();
		
		while(!stack.empty())
			reverseString.append(stack.pop());
		
		return reverseString.toString();
	}
}
