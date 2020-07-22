package DataStructures;

public class Trie
{
    private class Node
    {
        private char character;
        private Node[] children =  new Node[26];
        private boolean isEndOfWord;

        public Node()
        {

        }
        public Node(char character)
        {
            this.character = character;
        }
    }

    Node root = new Node();

    public void insert(String word)
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
        {
            node.children[difference] = new Node(newCharacter);
            return node.children[difference];
        }
        return node;
    }
}
