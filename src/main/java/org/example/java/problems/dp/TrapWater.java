package org.example.java.problems.dp;
/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it can trap after raining.
 */
public class TrapWater {

    public static void main(String args[]){
    int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trap(array));
    }

    public static int trap(int[] height) {
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int heightLeft = 1;
        int heightRight = 1;
        for(int i =1;i<height.length-1;i++){
            heightLeft = Math.max(heightLeft , height[i]);
            left[i] = heightLeft;
        }

        for(int i = height.length-2;i> 1;i--){
            heightRight = Math.max(heightRight , height[i]);
            right[i] = heightRight;
        }
        for(int i= 1;i< height.length;i++){
            sum = sum+ (Math.min(left[i], right[i])-height[i]);
        }

        return sum;
    }
}
