package DataStructures;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringUtil
{
    public static int countVowels(String string)
    {
        if (string == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (char character : string.toCharArray())
            if (vowels.contains(Character.toString(character)))
                count++;
        return count;
    }

    public static String reverseString(String string)
    {
        if (string == null)
            return "";

        Stack<Character> stack = new Stack<>();

        for (var character: string.toCharArray())
            stack.push(character);

        StringBuffer stringBuffer = new StringBuffer();
        while(!stack.isEmpty())
            stringBuffer.append(stack.pop());

        return stringBuffer.toString();

    }

    public static String reverseSentence(String string)
    {
        if (string  == null)
            return "";

        String[] strings = string.split(" ");
        Stack<String> stack = new Stack<>();

        for (String str: strings)
            stack.push(str);

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty())
        {
            stringBuilder.append(stack.pop());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }

    public static boolean isRotation(String string1 , String string2)
    {
        if (string1 == null || string2 == null)
            return false;

        return ((string1.length() == string2.length()) &&
                (string1 + string1).contains(string2));
    }

    public static String removeDuplicate(String string)
    {
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var character : string.toCharArray())
        {
            if (!seen.contains(character))
            {
                seen.add(character);
                output.append(character);
            }
        }

        return output.toString();
    }

    public static char mostRepeatedChar(String string)
    {
        final int ASCI_SIZE = 256;
        int[] frequency = new int[ASCI_SIZE];

        for (char character: string.toCharArray())
            frequency[character]++;

        int max = 0;
        char character = ' ';
        for (int index = 0; index < frequency.length;index++)
        {
            if (frequency[index] > max)
            {
                max = frequency[index];
                character = (char) index;
            }
        }
        return character;
    }
}
