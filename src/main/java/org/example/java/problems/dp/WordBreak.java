package org.example.java.problems.dp;

import java.util.*;

/*

139. Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

This is not just matching words — it's:

“Can I break the string at some index such that:
left part is valid AND right part is valid?”

This screams:
👉 Dynamic Programming
 */
public class WordBreak {

    public static void main(String args[]){
        List<String> dict= Arrays.asList(new String[]{"leet","code"});
       System.out.println(wordBreak("leetcode",dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean val = false;
        Map<String, Boolean> memo = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        for(String word : wordDict){
            wordSet.add(word);
        }
        val =  findWords(memo,s,wordSet);
        return val;

    }

    public static boolean findWords(Map<String, Boolean> memo, String s, Set<String> wordSet){

        int n=s.length();
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        if(wordSet.contains(s)) return true;
        for(int i=1 ;i<n;i++){
            String prefix = s.substring(0, i);
            if(wordSet.contains(prefix) && findWords(memo,s.substring(i),wordSet)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }


}
