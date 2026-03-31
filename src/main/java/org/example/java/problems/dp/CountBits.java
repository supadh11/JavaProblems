package org.example.java.problems.dp;

import java.util.Arrays;

/*

338. Counting Bits
Given an integer n, return an array ans of length n + 1
such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.


 */
public class CountBits {

    public static void main(String args[]){
        Arrays.stream(countBits(10)).forEach(x -> System.out.println(x));
    }

    public static int[] countBits(int n) {

        int[] retArray = new int[n+1];
        int sub =1;
        retArray[0] = 0;
        for(int i =1;i <= n;i++){
            if(sub * 2 == i){
                retArray[i] = 1;
                sub = i;
            }else{
                retArray[i] = retArray[i-sub]+1;
            }
        }
        return retArray;

    }
}
