package org.example.java.problems.bst;

import java.util.Arrays;
/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Solution : In this approach using binary search and then moving the pointer to left and right once we find the target.
to find the start and end index;
Another approach is to find the first adn last separately.

private int findFirst(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    int ans = -1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            ans = mid;
            end = mid - 1; // move left
        } else if (nums[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return ans;
}

private int findLast(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    int ans = -1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            ans = mid;
            start = mid + 1; // move right
        } else if (nums[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return ans;
}
 */
public class FirsAndLastPosition {

    public static void main(String args[]){

         Arrays.stream(searchRange(new int[]{2,3}, 2)).forEach(num -> {
            System.out.print(" " + num);
        });

    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        if(nums.length == 1){
            if(nums[0]== target)
                return new int[]{0,0};
            else
                return new int[]{-1,-1};
        }
        while(start <= end){

            int mid = (start + end )/2;
            if(nums[mid] == target){
                int i= mid, j = mid;
                while(i >= 0 && nums[i] == target ){
                    i--;
                }
                while(j < nums.length && nums[j] == target){
                    j++;
                }

                return new int[]{i+1,j-1};

            }
            if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return new int[]{-1,-1};
    }
}
