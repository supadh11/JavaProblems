package org.example.java.problems.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

15. 3Sum
Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
[-1,0,1,2,-1,-4]
Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static void main(String args[]){
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}).stream().forEach(list -> {
            list.stream().forEach(ele -> System.out.print(ele+ ", "));
            System.out.println("");
        }
        );

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> intList = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3) return intList;
        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i] ==  nums[i-1]) continue;  // to remove duplicates
            int j = i+1;  // starting pointer
            int k = nums.length-1; // end pointer
            while(j<k){
                int total = nums[i] + nums[j] + nums[k];
                if( total == 0){
                    intList.add(Arrays.asList( nums[i] ,nums[j],nums[k]));
                    j++; // move the pointer forward
                    while(nums[j] == (nums[j-1])){ // check to skip duplicate numbers
                        j++;
                    }
                }else if (total < 0){  // if total is less than 0 move j to the right
                    j++;
                }else{ // if total is more than 0 move k to the left
                    k--;
                }

            }
        }

      return  intList;
    }
}
