package org.example.java.problems.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Solution :
Use backtracking
1) Take a string builder and add each char in to that for every digit
2) if sb length rquals length of digits add sb to list and return
3) inside the loop we have to delete the last char added
 */
public class LetterCombinationNumber {

    public static void main(String args[]){

        (letterCombinations("237")).stream().forEach((x) -> {System.out.print(x + ", ");});

    }

    public static List<String> letterCombinations(String digits) {

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', List.of("a","b","c"));
        map.put('3', List.of("d","e","f"));
        map.put('4', List.of("g","h","i"));
        map.put('5', List.of("j","k","l"));
        map.put('6', List.of("m","n","o"));
        map.put('7', List.of("p","q","r","s"));
        map.put('8', List.of("t","u","v"));
        map.put('9', List.of("w","x","y","z"));

        if(digits.length() == 1) return map.get(digits.charAt(0));

        char[] charArray = digits.toCharArray();
        List<String> tempList = new ArrayList<>();


         recursion(tempList,map, digits,0, new StringBuilder());

         return tempList;
    }

    public static void recursion(List<String> returnList, Map<Character, List<String>> charMap,String digits,int index, StringBuilder sb){
        if(index == digits.length()){
            returnList.add(sb.toString());
            return;
        }
        List<String> letterList = charMap.get(digits.charAt(index));
        for(int i =0;i< letterList.size();i++){
            sb.append(letterList.get(i));
            recursion(returnList,charMap, digits,index+1, sb);

            sb.deleteCharAt(sb.length()-1);
        }
    }


}
