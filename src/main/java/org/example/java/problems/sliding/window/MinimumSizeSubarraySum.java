package org.example.java.problems.sliding.window;
/*
209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Solution :
For Array : {1,2,3,2,4,3} left and right starts at 0 index. There are two loops but O(N), as each element is traversed once.
for right we go from 0 to length-1 and for left we keep on increasing the index till we find the minimum length where target is still less than sum

 */
public class MinimumSizeSubarraySum {

    public static void main(String args[]){

      System.out.print(  minSubArrayLen(7,new int[]{1,2,3,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0;i< nums.length;i++){
            sum = sum+nums[i];
        while(sum >= target){
                minLength = Math.min(minLength, i-left+1);
                sum = sum - nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE? 0:minLength;

    }
}
