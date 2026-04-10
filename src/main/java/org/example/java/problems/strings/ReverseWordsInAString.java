package org.example.java.problems.strings;
/*

151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWordsInAString {

    public static void main(String args[]){
        System.out.print(reverseWords("a good   example"));

    }

    public static String reverseWords(String s) {
        StringBuffer returnString = new StringBuffer();
        String[] arrayStr = s.split(" ");
        for(int i = arrayStr.length-1;i>= 0;i--){
            if(arrayStr[i] != "") {
                returnString.append(arrayStr[i]).append(" ");
            }
        }

        returnString =  returnString.length() > 1 ? returnString.replace(returnString.length()-1, returnString.length(),""):returnString;
        return returnString.toString();
    }
}
