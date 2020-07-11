package DataStructures;




import javax.sound.sampled.ReverbType;

public class Main 
{
	public static void main(String[] args) 
	{
		
		String stringValue = "Hello world";
		StringReverser reverser = new StringReverser();
		String value = reverser.reverse(stringValue);
		System.out.println(value);
	}

}
