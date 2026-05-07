package org.example.java.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*

57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Solution :

I was trying to merge going sequentially as per the examples given but that would miss multiple cases like ig newInterval has both values lesser than first array in interval

Modified approach : Use 3 while loops
first to insert all the array elements as is when the newInterval > interval[i][1]
second to merge using Math.min for first element and Math.max for second element
Third to insert all the remaining elements where i < len

 */
public class InsertIntervals {

    public static void main(String args[]){
       int[][] arr = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
       int[] interval = new int[]{4,8};

      // int[][] arr = new int[][]{{1,3},{6,9}};
      //  int[] interval = new int[]{2,5};
        Arrays.stream((insert(arr, interval))).forEach( arrs -> {
            Arrays.stream(arrs).forEach( a -> System.out.print(","+a));
                    System.out.println("");
        });
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        result.add(newInterval);

        // 3. Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
   /* public static int[][] insert(int[][] intervals, int[] newInterval) {
        int first = newInterval[0];
        int second = newInterval[1];
        int len = intervals.length;
        ArrayList<List<Integer>> arrayList = new ArrayList<>();

        boolean merged = false;

        if(intervals.length == 0) return new int[][]{newInterval};
        if(newInterval.length == 0) return intervals;



        for (int i = 0;i<len;i++){

            if(intervals[i][0] < first && intervals[i][1] > first && !merged){
                List<Integer> tempList =new ArrayList<>();
                tempList.add(intervals[i][0]);
                int j = i;
                while(intervals[j][1] <= second){
                    j++;
                }
                if(intervals[j][0] <= second) {
                    tempList.add(Math.max(second, intervals[j][1]));
                    arrayList.add(tempList);
                    merged = true;
                    i = j;
                }else{
                    tempList.add( Math.max(intervals[j-1][1], second));
                    arrayList.add(tempList);
                    merged = true;

                }
            }else{
                List<Integer> tempList =new ArrayList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[i][1]);
                arrayList.add(tempList);
            }
        }
        int[][] returnArray = new int[arrayList.size()][2];
        for(int i = 0;i< arrayList.size();i++){
            returnArray[i][0] = arrayList.get(i).get(0);
            returnArray[i][1] = arrayList.get(i).get(1);
        }

        return returnArray;
    }
    */

}
