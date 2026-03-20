package org.example.java.problems.misc;


/*
264. Ugly Number II

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.



Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

Solution :
1) We have to consider the numbers that are ugly and not all the numbers
2) next ugly number will be min. of multiple of 2,3,5 for previous 3 ugly numbers
3) take 3 pointers to represent previous ugly numbers for each 2,3,5
4) Check the min. of multiples of those numbers with 2,3 and 5 and assign the min
5) increment the index for that particular number

 */
public class NthUglyNumber {

    public static void main(String args[]){
        System.out.println(nthUglyNumber(19));
    }

    public static int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if(nums[i] == nums[index2] * 2)
                index2++;
            if(nums[i] == nums[index3] * 3)
                index3++;
            if(nums[i] == nums[index5] * 5)
                index5++;
        }
        return nums[n - 1];

    }
}
