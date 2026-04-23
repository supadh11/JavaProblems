package org.example.java.problems.trie;

/*
208. Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 Solution :

 Create a class TrieNode to keep each alphabet of a word.
 Each TrieNode will contain an array of TrieNode of size 26.
 also keep a boolean variable to tell if it is the last node, it will return true for each inserted word
 (so for app and apple, it will hold true for p as well as e)
 insert
    keep on adding each char to a new node and assign temp node as the new node if the character doesnt exist already
    if the char exist, get it and create a new node and assign it to the childNode[c-'a] place
 search
    loop over each word and check if it exists or not in the childNodes
        if it  exists then assign the childNode to the tempNode
        else return false;
     return if it is last node or not

  same for prefix, just dont check if it is last node or not

 */

public class Trie {

    TrieNode root;
    public Trie() {
    root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(temp.contains(c)) temp = temp.get(c);
            else {
                temp.childNode[c-'a'] = new TrieNode();
                temp = temp.get(c);
            }
        }
        temp.isLastNode = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(temp.childNode[c-'a'] != null){
                temp = temp.get(c);
            }else{
               return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char c : prefix.toCharArray()){
            if(temp.childNode[c-'a'] != null){
                temp = temp.get(c);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Trie obj = new Trie();
        obj.insert("word");
        boolean param_2 = obj.search("word");
         boolean param_3 = obj.startsWith("prefix");
        boolean param_4 = obj.startsWith("wor");
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
    private static class TrieNode{

        TrieNode[] childNode = new TrieNode[26];
        boolean isLastNode = false;
        public boolean contains(char c){
            return childNode[c-'a'] != null;
        }

        public TrieNode get(char c){
            return childNode[c-'a'];
        }
    }
}
