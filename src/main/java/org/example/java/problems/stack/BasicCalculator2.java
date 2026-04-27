package org.example.java.problems.stack;
/*
224. Basic Calculator

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Solution :
Add only the sign and the result of brackets in to the stack. Dont add sign or brackets on stack
use a loop and in that loop divide the condition in to four using
1) if digit keep on adding the digits while it is a number, finally calculate the result, dont add it just now on stack
2) if it is + or - sign toggle a integer to -1 or 1
3) if it is ( push current result and sign
4) if it is ) pop current result and sign result = result * stack.pop() + stack.pop();

 */
import java.util.Stack;

public class BasicCalculator2 {

    public static void main(String args[]){
        System.out.println(calculate("-1 + 2"));

    }

    public static int calculate(String s) {
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for(int i = 0;i<len;i++){
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            }
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
            if (s.charAt(i) == '+') {
                sign = 1;
            }
            if (s.charAt(i) == '-') {

                sign = -1 ;
            }

        }

        return result;
    }

    private static boolean isNumeric(char c){
        if(c == '1' || c == '2' || c == '3' || c == '4' ||c == '1' ||c == '5' ||c == '6' ||c == '7' ||c == '8' ||c == '9' ||c == '0' ){
            return true;
        }else{
            return false;
        }
    }
}
