package org.example.java.problems.dp;

import java.util.Arrays;

/*
300. Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
Solution :

Take a dp array and store the number of elements before it that are smaller than it
 */
public class LongestIncreasingSubsequence {

    public static void main(String args[]){

       System.out.println( lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {

        if(nums.length == 1 || nums.length == 0) return nums.length;
        int[] arrayCopy = new int[nums.length];
        Arrays.fill(arrayCopy,1);
        int max = 0;
        for(int i = 1;i< nums.length;i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    arrayCopy[i] = Math.max(arrayCopy[i], arrayCopy[j] + 1);
                }
                max=Math.max(max,arrayCopy[i]);
            }
        }



        return max;


    }


}
