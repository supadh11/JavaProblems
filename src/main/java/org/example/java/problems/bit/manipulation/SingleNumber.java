package org.example.java.problems.bit.manipulation;
/*
136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

1. XOR of a number with itself is 0 (a ^ a = 0 , any number XOR with itself is zero)
2 . XOR of a number with 0 is the number itself (a ^ 0 = a),any number XOR with zero is the number itself
3 . XOR is commutative and associative (order doesn't matter)
 */
public class SingleNumber {

    public static void main(String args[]){
        System.out.println(singleNumber(new int[]{1, 2, 1, 2, 3, 4, 3}));
    }

    public static int singleNumber(int[] nums) {
        int singleNumber = 0;
        for(int i =0;i<nums.length;i++){
            singleNumber = singleNumber^nums[i];
        }

        return singleNumber;
    }
}
