package org.example.java.problems.backtrack;

import java.util.ArrayList;
import java.util.List;




/*

77. Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

[{1,2,3},{2,3,4},{3,4,5},{2,3,5},{1,3,4},{1,3,5},{1,4,5},{2,4,5},{1,2,5},{1,3,4}]

Solution :
Use backtracking as it needs combinations and for k size
1) create a recursion method passing a list and returning list along with all the size vars
2) Keep on adding the elements from start index till the size index in to the list
3) call the recursion methods inside the loop by increasing the start counter
4) remove the last added number to clear the list
5) as soon as size of list becomes k add it to the returning list
 */
public class Combinations {

    public static void main(String args[]){
            combine(5,3).stream().forEach((list) -> {

                list.stream().forEach((val) -> {
                    System.out.print(val+",");
                });
                System.out.println("");
            });
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> integerSet = new ArrayList<>();
         backTrackCombinations(returnList,integerSet,1,n,k);
        return returnList;
    }

    private static void backTrackCombinations(List<List<Integer>> returnList, List<Integer> integerSet,int start, int n , int k) {
        if(integerSet.size() == k){
            returnList.add(new ArrayList<>(integerSet));
            return;
        }
        for(int i = start;i<=n;i++){
            integerSet.add(i);
            backTrackCombinations(returnList, integerSet,i+1,n,k);
            integerSet.remove(integerSet.size()-1);
        }
    }
}
