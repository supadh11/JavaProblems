package org.example.java.problems.bst;
/*
33. Search in Rotated Sorted Array
Whenever you see:

rotated
sorted array
search
At every step:

Find mid
Check which half is sorted
Check if target lies in that sorted half
Narrow search accordingly

👉 Think:
Binary Search + Identify Sorted Half
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
public class RotatedBinarySearch {

    public static void main(String args[]) {

       System.out.println( search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target &&   target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
