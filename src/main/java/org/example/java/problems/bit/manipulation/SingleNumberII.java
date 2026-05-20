package org.example.java.problems.bit.manipulation;
/*
137. Single Number II

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

 Keep two variables storing the elements occuring once and twice.
 ones = (ones ^ nums[i]) & ~twos;
        ones ^ nums[i] -> find the number that occurs once
        & ~twos   -> finds the bits that doesnt occurs in two and removes them from 1
 same with twos = (twos ^ nums[i]) & ~ones;
         twos ^ nums[i]  -> store the number that occurs twice
         & ~ones -> removes the bits from two that doesnt occur in ones


 */
public class SingleNumberII {

    public static void main(String args[]){

        System.out.println(singleNumber(new int[]{2,2,3,2,3,1,3}));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for(int i =0;i<nums.length;i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}
