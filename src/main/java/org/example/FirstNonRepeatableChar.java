package org.example;


/*
Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note : When you return '$' driver code will output -1.
https://geeksforgeeks.org/problems/non-repeating-character-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatableChar {

    public static  void main(String args[]){

        System.out.println(nonrepeatingCharacter("test"));
    }
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        char returnVal = '$';
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<S.length();i++){
            Character ch = S.charAt(i);
            if(map.get(ch) == null){
                map.put(ch, 1);
            }else{
                map.put(ch,-1);
            }
        }

        for(int i =0;i<S.length();i++){
            if(map.get(S.charAt(i)) != null
                    && map.get(S.charAt(i)).equals(1)){
                returnVal = S.charAt(i);
                break;
            }
        }

        return returnVal;
    }

}
