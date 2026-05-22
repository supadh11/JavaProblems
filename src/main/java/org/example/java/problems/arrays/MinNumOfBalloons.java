package org.example.java.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;

/*

452. Minimum Number of Arrows to Burst Balloons
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path
Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

Solution :

Step 1 Sort the array as per the last element
Step 2 : Use a loop to compare the 0th element of current index with 1st element of previous index.
if the 0th element is bigger that means there is no overlap, so we need to use an extra arrow, increment the arrow count
{10,16},{2,8},{1,6},{7,12}  -> {1,6},{2,8},{7,12},{10,16}
{2,8} -> i = 1 ,  previous = 0,arrow = 1,
{7,12} -> i = 2, previous = 0 -> 7 > 6 , arrow = 2, previous = 2

 */
public class MinNumOfBalloons {

    public static void main(String args[]){

    System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        if(points.length == 0) return 0;
        int arrow = 1;
        int previous = 0;
        for(int i = 1;i< points.length;i++){
            if(points[i][0] > points[previous][1]){
                arrow++;
                previous = i;
            }
        }
        return arrow;
    }


}

