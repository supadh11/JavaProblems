package org.example.java.problems.arrays;

import java.util.Arrays;

/*
238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Solution : multiply from 0 -> n and store it in an array
then multiply from n -> 0 and store it in an array
then multiply both the arrays.



 */
public class ProductOfArray {

    public static void main(String args[]){
        int[] arr = new int[]{-1,1,0,-3,3};

        Arrays.stream(productExceptSelf(arr)).forEach(a ->{System.out.print(a+ " ,");});

    }

    public static int[] productExceptSelf(int[] nums) {

        int[] ret = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int num = 1;
        int num1 = 1;
        for(int i = 0;i< nums.length;i++){
            left[i] = num;
            num = num*nums[i];
        }
;
        for(int i = nums.length-1;i >=0;i--){
            right[i] = num1;
            num1 = num1*nums[i];
        }

        for(int i = 0;i<nums.length;i++){
            ret[i] = left[i] * right[i];
        }

        return ret;
    }
}
