package org.example.java.problems.strings;
/*

392. Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed\
 from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

Solution :

1) Take a pointer and track it for the length of subString
2) fetch the char at pointer from subsequence and match it in the loop over the length of the string
3) if pointer == length of the subsequnce returns true else false;

 */
public class IsSubsequence {

    public static void main(String args[]){
    System.out.println(isSubsequence("axc","ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        boolean isSub = false;
        char[] charArr = t.toCharArray();
        int pointer = 0;
        for(char c : charArr){
            if(pointer < s.length() && c == s.charAt(pointer)){
                pointer++;
            }
        }
        System.out.println(pointer);
        if(pointer == s.length()){
            isSub = true;
        }
        return isSub;
    }
}
