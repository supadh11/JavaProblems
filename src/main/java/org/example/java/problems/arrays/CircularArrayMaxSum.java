package org.example.java.problems.arrays;

/*
918. Maximum Sum Circular Subarray
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2


Solution :
Find MaxSum of the array
Find MinSum of the array
Find Totla Sum of the array
Max Sum of circular array would be Maximum of (maxSum, totalSum - minSum)
 */
public class CircularArrayMaxSum {

    public static void main(String args[]){

        System.out.println(maxSubarraySumCircular(new int[]{1,2,-3,4,-6,3}));

    }
    public static int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for(int i =1;i< nums.length;i++){
            sum += nums[i];
            currMax = Math.max(nums[i], currMax+nums[i]);
            max = Math.max(max, currMax);
            currMin = Math.min(nums[i], currMin+nums[i]);
            min = Math.min(min, currMin);
        }
        if(max < 0) return max;
        return  Math.max(max,sum - min);

    }
}
