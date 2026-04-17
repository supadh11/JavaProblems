package org.example.java.problems.arrays;
/*

53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Solution :
Take a currentSum variable and keep on adding current value in it.
if it becomes greater than maxSum assign maxSum as currentSum
if currentSum is less than 0 then make it 0, as whenever we get currentSum
as less than 0 we will ignore all the records covered till now and start afresh so make currentSum as 0.

 */
public class MaximumSumSubArray {

    public static void main(String args[]){
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
             int sum = 0;
          for(int i = 0;i< nums.length;i++){

              sum = sum+ nums[i];
              maxSum = maxSum > sum ? maxSum:sum;
              if(sum < 0){
                  sum =0;
              }
          }
          return maxSum;
    }


}
