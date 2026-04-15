package org.example.java.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/*
228. Summary Ranges
You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:
Solution :
Start a while loop and take a start and end index. take another while loop inside the loop to move the end index, we can move it till the next number is in sequence
outside the inner loop check the vaule of start and end index, if they are equal add the number to the list if not add the sequence to the list
 */
public class SummaryRanges {
    public static void main(String args[]){

        int[] arr = new int[]{0,2,4,5,7,9};
        summaryRanges(arr).stream().forEach((a) -> System.out.print(a + ", "));
    }

    public static List<String> summaryRanges(int[] nums) {
    List<String> returnList = new ArrayList<>();

    int index =0;


    while(index < nums.length){
        int number = nums[index];
        int j = index;
        String s = "";
        while(j+1 < nums.length && nums[j]+1 == nums[j+1]){
            j++;
        }
       if(index == j){
           s = ""+nums[index];
       }else{
           s= nums[index]+ "->" + nums[j];
       }
        returnList.add(s);
       index = j+1;
    }
    return returnList;
    }
}
