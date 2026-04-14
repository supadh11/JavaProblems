package org.example.java.problems.backtrack;

import java.util.ArrayList;
import java.util.List;




/*

46. Permutations
Given an array nums of distinct integers,
 return all the possible permutations.
 You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Solution :
Use backtracking as it needs all possible permutaion

same backtrack strategy, recursion in the loop add the element and call recursive method and remove the element
add the elements in case size is equal to the number
dont start with i+1, as we need all the permutations, just make sure we dont add the duplicate number to the tempList.

 */
public class Permutations {

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3};
        permute(nums).stream().forEach((list) -> {

            list.stream().forEach((val) -> {
                System.out.print(val+",");
            });
            System.out.println("");
        });
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> integerList  = new ArrayList<>();
        backTrackCombinations(returnList,integerList, nums);
        return returnList;
    }

    private static void backTrackCombinations(List<List<Integer>> returnList, List<Integer> integerList, int[] nums) {
        if(integerList.size() == nums.length){
            returnList.add(new ArrayList<>(integerList));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(integerList.contains(nums[i])) continue;
            integerList.add(nums[i]);
            backTrackCombinations(returnList, integerList, nums);
            integerList.remove(integerList.size()-1);
        }
    }
}
