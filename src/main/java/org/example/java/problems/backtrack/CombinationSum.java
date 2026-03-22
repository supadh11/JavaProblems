package org.example.java.problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Solution : Follow the backtrack pattern
1) Sort the elements of the array
2) call  the backtrack function by passing the target, index, tempList , returnList and candidates
    -- In the backtrack function check if the target is 0, then add the tempList to the returnList;
3) In the backtrack function, use a loop for all the elements from the index to combinedSum length
4) add the element to the tempList
5) call the backtrack function by passing target - element, index(because of repeatable characters), tempList, returnList and candidates
6) remove the element from the tempList

 */
public class CombinationSum {

    public static void main(String args[]){
        int[] candidates = {2,3,6,7};
        combinationSum(candidates, 7).stream().forEach((list) -> {

            list.stream().forEach((val) -> {
                System.out.print(val+",");
            });

        });
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnList= new ArrayList<>();
        Arrays.sort(candidates);

            backtrack(candidates, returnList, new ArrayList<Integer>(),target, 0);

        return returnList;

    }

    private static void backtrack(int[] candidates, List<List<Integer>> returnList, List<Integer> tempList,int target, int candidatesIndex) {
        if(target < 0) return;
        else if(target == 0){
            returnList.add(new ArrayList<>(tempList));
        }else{
            for(int i = candidatesIndex;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backtrack(candidates, returnList, tempList,target-candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
