package org.example.java.problems.hashmap;

import java.util.HashSet;
import java.util.Set;
/*
202. Happy Number
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Solution use a loop to keep checking till the sum becomes 1
inside the loop take another loop to break the number and do sum of its square
also take a set to keep adding the sum in it, once you find the sum is already there you can break out of loop. This is done to avoid infinite looping.

 */
public class HappyNumber {

    public static void main(String args[]){

    System.out.print(isHappy(2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(sum != 1){

            while(n > 0){
                int mod = n%10;
                sum = sum+ (mod*mod);
                n = n/10;
            }
            if(sum == 1){
                return true;
            }else{
                if(set.contains(sum)){
                    return false;
                }
                set.add(sum);
                n = sum;
                sum =0;
            }


        }

        return false;
    }
}
