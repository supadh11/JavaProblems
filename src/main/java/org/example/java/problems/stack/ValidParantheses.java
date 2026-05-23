package org.example.java.problems.stack;
/*

20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

solution use stack
 */
import java.util.Stack;

public class ValidParantheses {

    public static void main(String args[]){
    System.out.print(isValid("()"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() == 0){
            return true;
        }
        for(int i =0;i<s.length();i++){

            if(s.charAt(i) == '(' ){
                stack.push(')');
            }else if( s.charAt(i) == '[' ){
                stack.push(']');
            } else if( s.charAt(i) == '{' ){
                stack.push('}');
            }

            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
               if(!stack.empty()) {
                   if (s.charAt(i) != stack.pop()){
                       return false;
                   }
               }else{
                   return false;
               }
            }
        }

        return stack.empty();
    }
}
