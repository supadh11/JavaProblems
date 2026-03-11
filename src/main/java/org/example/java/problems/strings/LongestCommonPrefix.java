package org.example.java.problems.strings;
/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String argsp[]){
        String[] arr = new String[]{"test","tes","testing","tea"};
                String str = longestPrefix(arr);
                System.out.println(str);
    }

    private static String longestPrefix(String[] arr) {

        String prefix = arr[0];
        int prefixLen = prefix.length();
        for(int i =1;i<arr.length;i++){
            while(!arr[i].startsWith(prefix)){
                prefixLen--;
                prefix = prefix.substring(0,prefixLen);
            }
            if(prefix.length() == 0){
                return "";
            }
        }
        return prefix;
    }
}
