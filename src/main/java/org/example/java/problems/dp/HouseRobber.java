package org.example.java.problems.dp;
/*
198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

 */
public class HouseRobber {
    public static void main(String args[]){
       int[] array =  {2,7,9,3,1};
        System.out.println(rob(array));
    }

    public static int rob(int[] nums) {
         return  findMaxSum(nums, nums.length);
    }

    private static int findMaxSum(int[] nums, int i) {
        if(i <= 0) return 0;
        if(i == 1) return nums[0];
        int sum1 = nums[i-1] + findMaxSum(nums, i-2);
        int sum2 = findMaxSum(nums, i-1);

        return Math.max(sum1, sum2);
    }
}
