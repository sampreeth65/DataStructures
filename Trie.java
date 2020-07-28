package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie
{
    private class Node
    {
        private char character;
        //private Node childern = new Node[26];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node() {

        }

        public Node(char character) {
            this.character = character;
        }

        public String toString() {
            return "Value = " + character;
        }

        public boolean hasChild(char character) {
            return children.containsKey(character);
        }

        public void addChild(char character) {
            children.put(character, new Node(character));
        }

        public Node getChild(char character) {
            return children.get(character);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch)
        {
            children.remove(ch);
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

        for (char character : word.toCharArray()) {
            if (!currentNode.hasChild(character))
                currentNode.addChild(character);
            currentNode = currentNode.getChild(character);
        }
        currentNode.isEndOfWord = true;
    }

    public boolean contains(String word)
    {
        if (word == null)
            return false;

        Node currentNode = root;

        for (char character : word.toCharArray()) {
            if (!currentNode.hasChild(character))
                return false;
            currentNode = currentNode.getChild(character);
        }

        if (currentNode.isEndOfWord != true)
            return false;

        return true;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        for (Node child : root.getChildren())
            traverse(child);

        System.out.println(root.character);
    }

    public void remove(String word) {
        if (word == null)
            return;

        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index)
    {
        if (index == word.length())
        {
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child,word,index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }


    //currentWord
    //check every letter is endOfWord, if it is then add to list
        /*
          next check for children of the word, If it has children, start with first letter in
          array, go down in that array till end of word. next repeat the process till the end of the array.
          */
    // As you reach the end of the word in the array, add it to the list.

    //Recursive requires 3 parameter - Node root,
    // String that represents the current word,
    //List<Strings> words

    public List<String> findWord(String word)
    {
        List<String> words = new ArrayList<>();

        if (word == null)
            return words;

        if (word.length() == 0)
            return words;

        Node lastNode = findLastNode(word);

        findWords(lastNode,word,words);

        return words;
    }

    private void findWords(Node root,String prefix,List<String> words)
    {
        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (Node child: root.getChildren())
            findWords(child,prefix + child.character,words);
    }

    private Node findLastNode(String prefix)
    {
        Node currentNode = root;

        for(char character: prefix.toCharArray())
        {
            Node child = currentNode.getChild(character);
            if (child == null)
                return null;
            currentNode = child;
        }
        return currentNode;
    }

    public boolean containsRec(String word)
    {
        return containsRec(root,word,0);
    }

    private boolean containsRec(Node root,String word,int index)
    {
        if (index == word.length())
        {
            return root.isEndOfWord ? true : false;
        }

        if (!root.hasChild(word.charAt(index)))
            return false;



        root = root.getChild(word.charAt(index));
        return containsRec(root,word,index + 1);
    }

    public int countWords()
    {
        return countWords(root,0);
    }

    private int countWords(Node root,int counter)
    {
        if (root.isEndOfWord)
            counter++;

        for (Node node : root.getChildren())
            counter = countWords(node,counter);

        return counter;
    }
}
