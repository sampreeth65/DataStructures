package DataStructures;

import java.util.Stack;

public class Expression 
{
	public boolean isBalanced(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for (char character : str.toCharArray())
		{
			if (character == '(' || character == '{' || character == '[' || character == '<')
				stack.push(character);
			
			if (character == ')')
			{
				if  (stack.empty()) 
					return false;
				if (stack.pop() != '(')
					return false;
			}
			
			if (character == '}')
			{
				if  (stack.empty()) 
					return false;
				if (stack.pop() != '{') 
					return false;
			}
			
			if (character == ']')
			{
				if  (stack.empty()) 
					return false;
				if (stack.pop() != '[')
					return false;
			}
			
			if (character == '>')
			{
				if  (stack.empty()) 
					return false;
				if (stack.pop() != '<')
					return false;
			}
		}
		return stack.empty();
	}
}
