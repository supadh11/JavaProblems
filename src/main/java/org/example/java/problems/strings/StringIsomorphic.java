package org.example.java.problems.strings;


import java.util.HashMap;
import java.util.Map;

/*
    Given two strings s and t, determine if they are isomorphic.

            Two strings s and t are isomorphic if the characters in s can be replaced to get t.

            All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

eg egg --> add
eg. paper --> title

foo !--> bar
*/
public class StringIsomorphic {

    public static void main(String[] args){
        StringIsomorphic iso = new StringIsomorphic();

        System.out.println(iso.isIsomorphic("badc","baba"));
        System.out.println(iso.isIsomorphic("paper","title"));
        System.out.println(iso.isIsomorphic("add","egg"));
        System.out.println(iso.isIsomorphic("foo","bar"));

    }

    public boolean isIsomorphic(String s, String t) {
        boolean isIsoMorph = true;
        Map<Character,Character> charMap = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }else{
            for(int i = 0;i<s.length();i++){
                if(charMap.get(s.charAt(i)) == null){
                    charMap.put(s.charAt(i),t.charAt(i));
                }else{
                    if( (charMap.get(s.charAt(i)))  != null && (charMap.get(s.charAt(i))) != t.charAt(i)
                    ){
                        isIsoMorph = false;
                    }
                }
            }
            charMap.clear(); //checking the second scenario for the 1st test case
            for(int i = 0;i<s.length();i++){
                if(charMap.get(t.charAt(i)) == null){
                    charMap.put(t.charAt(i),s.charAt(i));
                }else{
                    if( (charMap.get(t.charAt(i)))  != null && (charMap.get(t.charAt(i))) != s.charAt(i)
                    ){
                        isIsoMorph = false;
                    }
                }
            }
        }

        return isIsoMorph;
    }
}
