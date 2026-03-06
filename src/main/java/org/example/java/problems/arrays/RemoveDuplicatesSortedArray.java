package org.example.java.problems.arrays;

import java.util.Arrays;

/*
26. Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 */
public class RemoveDuplicatesSortedArray {

    public static void main(String args[]){

        int[] sortedArray = {1,1,2,3,5,6,6,7,7,9,10,10,10,19};
        int i = 0;

        if (sortedArray.length == 0) return;

        for (int j = 1; j < sortedArray.length; j++) {
            if (sortedArray[j] != sortedArray[i]) {
                i++;
                sortedArray[i] = sortedArray[j];
            }
        }
        for(int k =0;k<sortedArray.length;k++)
        System.out.println(sortedArray[k]);
    }
}
