package org.example.java.problems.sliding.window;

import java.util.Arrays;

/*
167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Solution : Use two pointer and keep on reducing or adding their value based on their sum as compared to target
if equals return their indexes+1
 */
public class TwoSum {

    public static void main(String args[]){
        Arrays.stream((twoSum((new int[]{2, 3, 4}), 6))).forEach(s -> {System.out.print(s+",");});
    }

    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 1 && numbers[0] == target) return new int[]{1,2};

        int right = numbers.length-1;
        int left = 0;
        while(left < right){
            long val = (long)numbers[left]+ (long)numbers[right];
            if(val == target){
                return new int[]{left+1,right+1};
            }else {
                if(val < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new int[]{left,right};
    }

}
