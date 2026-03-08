package org.example.java.problems.strings;

import java.util.ArrayList;
import java.util.List;

/*
67. Add Binary


Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class BinaryAddition {

    public static void main (String args[]){
        String a = "1010";
        String b = "1011";
        System.out.println("Value is "+binarySum(a,b));

    }

    private static String binarySum(String array, String brray) {
        char[] aNum = array.toCharArray();
        char[] bNum = brray.toCharArray();
        int length = 0;
        if (aNum.length >= bNum.length) {
            length = aNum.length;
        } else {
            length = bNum.length;
        }
        int aNumLength = aNum.length;
        int bNumLength = bNum.length;
        List<Character> charList = new ArrayList<>();
        Character carry ='0';
        for (int i = 0; i < length; i++) {
            Character a = (aNumLength - i - 1) >= 0?(array.charAt(aNumLength - i - 1)):'0';
            Character b = (bNumLength - i - 1) >= 0? brray.charAt(bNumLength - i - 1): '0';
            Character result ='0';
            if ((a.equals('1') && b.equals('0') && carry.equals('0'))
                    || (a.equals('0') && b.equals('1') && carry.equals('0'))
            || (a.equals('0') && b.equals('0') && carry.equals('1'))) {
                result = '1';
                carry = '0';
            } else if (a.equals('1') && b.equals('1') && carry.equals('0') ||
                    (a.equals('1') && b.equals('0') && carry.equals('1')) ||
                    (a.equals('0') && b.equals('1') && carry.equals('1'))) {
                result = '0';
                carry = '1';
            } else if (a.equals('0') && b.equals('0') && carry.equals('0')) {
                result = '0';
                carry = '0';
            } else if (a.equals('1') && b.equals('1') && carry.equals('1')) {
                result = '1';
                carry = '1';
            }
            charList.add(result);
        }

        if (carry == '1') {
            charList.add('1');
        }
        StringBuffer sb =  new StringBuffer("");
        for (int i = charList.size() - 1; i >= 0; i--) {
            sb.append(charList.get(i));
        }

        return sb.toString();

    }


}
