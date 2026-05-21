package org.example.java.problems.dp;
/*
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"

Solution  : We will consider each point as middle point and expand to its left and right till the chars are matching
if length of word is greater than maxlen we store j-k+1 to maxLen and low as j+1;

As there can be two possiblities like bb or bab we will call the palindrome twice with i,i and i, i+1

Take two variable to count maxLen and lower value.

 */
public class LongestPalindromeSequence {
    static int maxLength = 0;
    static int low = 0;
    public static void main(String args[]){

        System.out.println(longestPalindrome("Elizeabaeth"));
    }

    public static String longestPalindrome(String s) {

        int n = s.length();
        if(n < 2) return s;
        for(int i =0;i<n;i++){

            expandPalindrome(s.toCharArray(),i,i);
            expandPalindrome(s.toCharArray(),i,i+1);
        }

        return s.substring(low, maxLength+low);

    }

    private static void expandPalindrome(char[] charArray, int i, int j) {
        while(i >=0 && j < charArray.length && charArray[i] == charArray[j]){
            i--;
            j++;
        }
        if(maxLength < (j-i-1)){
            maxLength = j-i-1;
            low = i+1;
        }
    }
}
