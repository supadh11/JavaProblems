package org.example.java.problems.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 */
public class WordBreak {

    public static void main(String args[]){
        List<String> dict= Arrays.asList(new String[]{"leet","code"});
       System.out.println(wordBreak("leetcode",dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
    boolean val = false;
    Set<String> wordSet = new HashSet<>();
        for(String word : wordDict){
            wordSet.add(word);
        }
      val =  findWords(0,s,wordSet);
    return val;

    }

    public static boolean findWords(int p, String s, Set<String> wordSet){
        int n=s.length();
        if(p==n) {
            return true;
        }
        for(int i=p+1 ;i<=n;i++){
            if(wordSet.contains(s.substring(p,i)) && findWords(i,s,wordSet)) return true;
        }
        return false;
    }


}
