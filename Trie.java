package DataStructures;

import java.util.HashMap;

public class Trie
{
    private class Node
    {
        private char character;
        //private Node childern = new Node[26];
        private HashMap<Character,Node> children =  new HashMap<>();
        private boolean isEndOfWord;

        public Node()
        {

        }
        public Node(char character)
        {
            this.character = character;
        }

        public String toString()
        {
            return "Value = " + character;
        }

        public boolean hasChild(char character)
        {
            return children.containsKey(character);
        }

        public void addChild(char character)
        {
            children.put(character, new Node(character));
        }

        public Node getChild(char character)
        {
            return children.get(character);
        }
    }

    Node root = new Node();

    /*public void insert(String word)
    {
        Node currentNode = root;

        for (int index = 0; index < word.length();index++)
        {
            currentNode = insert(currentNode,word.charAt(index));

            if (index == word.length() - 1)
                currentNode.isEndOfWord = true;
        }
    }

    private Node insert(Node node, char newCharacter)
    {
        int difference = newCharacter - 'a';

        if (node.children[difference] == null)
            node.children[difference] = new Node(newCharacter);

        return node.children[difference];
    }*/

    public void insert(String word)
    {
        Node currentNode = root;

        for(char character : word.toCharArray())
        {
            if (!currentNode.hasChild(character))
                currentNode.addChild(character);
            currentNode = currentNode.children.get(character);
        }
        currentNode.isEndOfWord = true;
    }
}
