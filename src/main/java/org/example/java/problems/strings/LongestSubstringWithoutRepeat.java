package org.example.java.problems.strings;

import java.util.*;

/*
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters..
" "."tmmzuxt", "pwwkew", "dwdeft"

If we are using set then we have to keep track of the position of duplicate element and start from there.
That's why we have to use hashmap to keep track of the position.
|| charMap.get(charVal) < left -> add for the case tmmzuxt
in case if you find a duplicate then we have assign the left element to the previous position and update the value in the map

 */
public class LongestSubstringWithoutRepeat {

    public static void main(String args[]){

        System.out.print(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for(int i = 0;i< s.length();i++){
            Character charVal = s.charAt(i);
            if(charMap.get(charVal) == null || charMap.get(charVal) < left){
                charMap.put(charVal,i);
                maxLength = Math.max(maxLength, i-left+1);
            }else{
                left = charMap.get(charVal)+1;
                charMap.put(charVal, i);
            }
        }

        return maxLength;
    }

}
