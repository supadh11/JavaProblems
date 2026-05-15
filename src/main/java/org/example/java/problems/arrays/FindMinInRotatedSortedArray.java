package org.example.java.problems.arrays;
/*
153. Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

public int findMin(int[] arr) {

        int s = 0, e = arr.length - 1;

        while (s < e) {

            int mid = s + (e - s) / 2;

            // Minimum lies in right half
            if (arr[mid] > arr[e]) {
                s = mid + 1;
            }
            // Minimum lies in left half including mid
            else {
                e = mid;
            }
        }
        return arr[s];
    }
 */
public class FindMinInRotatedSortedArray {

    public static void main(String args[]){

        System.out.println(findMin(new int[]{3,4,5,6,1,2}));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];

        for(int i = 1;i<nums.length;i++){
            if(nums[i] < min){
                return nums[i];
            }

        }
        return min;
    }
}
