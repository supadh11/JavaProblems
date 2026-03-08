package org.example.java.problems.arrays;
/*
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchPositionInSortedArray {

    public static void main(String args[]){
        int[] array = {1,2,3,5,6,7,9};
        int target = 8;

                System.out.println( "Value is "+positionOfNum(array,target));
            }


            public static int positionOfNum(int[] nums, int target){
                int left = 0;
                int right = nums.length-1;
                int mid = 0;
                if(nums[right]<target) return nums.length;
                if(nums[left]>target) return 0;
                while(left <= right){
                    mid = (left+right)/2;
                    if(nums[mid] == target) {
                        return mid;
                    }
                    if(target > nums[mid]){

                        left++;
                    }else{

                        right--;
                    }

                }
                return mid;

            }
    }

