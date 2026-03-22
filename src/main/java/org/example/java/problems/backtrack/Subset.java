package org.example.java.problems.backtrack;

import java.util.ArrayList;
import java.util.List;



/*
78. Subsets
Given an integer array nums of unique elements, return all possible subsets (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.
        Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subset {

    public static void main(String args[]){
        int[] array = {1,2,3};
        List<List<Integer>> list = subsets(array);
        list.stream().forEach((val) -> {
            System.out.print(val+",");
        });
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();

        backtrack(nums, returnList, new ArrayList<Integer>(), 0);
        return returnList;
    }

    private static void backtrack(int[] nums, List<List<Integer>> returnList, ArrayList<Integer> tempList, int index) {
        returnList.add(new ArrayList<>(tempList));
        for(int i = index;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(nums, returnList,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }


}
