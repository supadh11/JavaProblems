package org.example.java.problems.strings;

import java.util.*;

/*
49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 */
public class GroupAnagrams {

    public static void main(String args[]){

        List<String> wordList = new ArrayList<>();
        wordList.add("bat");
        wordList.add("bta");
        wordList.add("btaa");
        wordList.add("cat");
        wordList.add("act");
        wordList.add("mat");
        wordList.add("bat");
        List<List<String>> retList = solution(wordList);
        retList.stream().forEach((list) ->System.out.println(list));
    }

    private static List<List<String>> solution(List<String> wordList) {
       List<List<String>> groupedList = new ArrayList<>();
       Map<String, List<String>> wordMap = new HashMap<>();
       for(String word : wordList){
           char[] array = word.toCharArray();
           Arrays.sort(array);
           String val = new String(array);
           if(!wordMap.containsKey(val)){
               wordMap.put(val,new ArrayList<String>());
               wordMap.get(val).add(word);
           }else{
               wordMap.get(val).add(word);
           }
       }

       for(String key: wordMap.keySet()){
           groupedList.add(wordMap.get(key));
       }
        return groupedList;
    }
}
