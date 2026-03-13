package org.example.java.problems.arrays;

/*

56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the non-overlapping
intervals that cover all the intervals in the input.

Solution :-
Sort intervals by start value.
Use a result list to store merged intervals.
If the current interval starts after the last interval ends → no overlap.
Otherwise update the end with the maximum value
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalArrays {

    public static void main(String args[]){
        int [][] intervals = {{1,4},{2,6},{8,10},{8,11},{8,9},{15,18},{2,4},{16,20}};
        
        mergeArrays(intervals);
    }

    private static int[][] mergeArrays(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->a[0] - b[0]);
        List<int[]>resultList = new ArrayList<>();

        for( int i=0;i<intervals.length;i++){
            if(resultList.isEmpty() || resultList.get(resultList.size()-1)[1] < intervals[i][0]){
                resultList.add(intervals[i]);
            }else{
                resultList.get(resultList.size()-1)[1] = Math.max(resultList.get(resultList.size() - 1)[1],intervals[i][1]);
            }

            }
        for( int i=0;i<resultList.size();i++){

               System.out.print("{"+resultList.get(i)[0]+","+resultList.get(i)[1]+"}");
            System.out.println("");
        }
       return resultList.toArray(new int[resultList.size()][]);
    }
}
