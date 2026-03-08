package org.example.java.problems.strings;

import java.util.HashMap;

/*

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
 */
public class WordPattern {

    public static void main(String args[]){

        String pattern = "abba";
        String stringVal = "dog cat cat do";

        boolean a = patternMatch(pattern,stringVal);
        System.out.println(a);
    }

    private static boolean patternMatch(String pattern, String stringVal) {

        String[] val = stringVal.split(" ");
        HashMap<Character, String> charMap = new HashMap<>();
        // for the case String pattern = "abba";
        //String stringVal = "dog dog dog dog";
        HashMap<String, Character> stringMap = new HashMap<>();
        boolean result = true;
        if(val.length != pattern.toCharArray().length){
            return false;
        }else if(stringVal.length() == 0 &&  pattern.length() == 0){
            return true;
        }
        for(int i =0;i<val.length;i++){
            if(!charMap.containsKey(pattern.charAt(i))){
                charMap.put(pattern.charAt(i), val[i]);
                if(!stringMap.containsKey(val[i])){
                    stringMap.put(val[i],pattern.charAt(i));
                }else{
                    if(!stringMap.get(val[i]).equals(pattern.charAt(i))){
                        result = false;
                    }
                }
            }else{
                String expected = charMap.get(pattern.charAt(i));
                if(!expected.equals(val[i])){
                    result = false;
                }
            }
        }

        return result;

    }

}
