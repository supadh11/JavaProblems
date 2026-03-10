package org.example.java.problems.sliding.window;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

solution ->
Initialize the variables:

left to represent the left pointer, starting at the beginning of the container (index 0).
right to represent the right pointer, starting at the end of the container (index height.size() - 1).
maxArea to keep track of the maximum area found, initially set to 0.
Enter a loop using the condition left < right, which means the pointers have not crossed each other yet.

Calculate the current area:

Use the min function to find the minimum height between the left and right pointers.
Multiply the minimum height by the width, which is the difference between the indices of the pointers: (right - left).
Store this value in the currentArea variable.
Update the maximum area:

Use the max function to compare the currentArea with the maxArea.
If the currentArea is greater than the maxArea, update maxArea with the currentArea.
Move the pointers inward: (Explained in detail below)

Check if the height at the left pointer is smaller than the height at the right pointer.
If so, increment the left pointer, moving it towards the center of the container.
Otherwise, decrement the right pointer, also moving it towards the center.
Repeat steps 3 to 5 until the pointers meet (left >= right), indicating that all possible containers have been explored.

Return the maxArea, which represents the maximum area encountered among all the containers.

 */
public class MaximumWaterContainer {

    public static void main(String args[]){
        int[] height = new int[]{1, 4, 5, 2, 3, 1, 4};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        if(height.length == 0 || height.length == 1){
            return 0;
        }else if(height.length == 2){
            return height[0]*height[1];
        }
        int i =0;
        int j = height.length-1;

        while(i<=j){
            int currentArea = (j-i)*min(height[i],height[j]);
            maxArea = max(currentArea,maxArea);
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }

}
