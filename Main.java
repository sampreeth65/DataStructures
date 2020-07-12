package DataStructures;




//import javax.sound.sampled.ReverbType;

public class Main 
{
	public static void main(String[] args) 
	{

		Stack stack = new Stack();
		//System.out.println(stack.peek());
		stack.push('9');
		stack.push('A');
		stack.push('B');
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		//stack.push('C');
	}

}
