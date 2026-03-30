package org.example.java.problems.dp;

import java.util.Arrays;

/*
279. Perfect Squares
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words,
 it is the product of some integer with itself.
 For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquare {

    public static void main(String args[]){

        System.out.println(numSquares(16));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int count = 1;
        while (count * count <= n) {
            int sq = count * count;
            for (int i = sq; i <= n; i++) {
                dp[i] = Math.min(dp[i - sq] + 1, dp[i]);
            }
            count++;
        }
        return dp[n];
    }



}
