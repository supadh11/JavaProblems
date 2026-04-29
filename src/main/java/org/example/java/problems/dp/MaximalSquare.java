package org.example.java.problems.dp;
/*
221. Maximal Square
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Solution : This means:

Look at top, left, and top-left diagonal
Take the smallest square among them
Add 1 (to include current cell

[
 ['1','0','1','0','0'],
 ['1','0','1','1','1'],
 ['1','1','1','1','1'],
 ['1','0','0','1','0']
]

DP matrix :
0 0 0 0 0 0
0 1 0 1 0 0
0 1 0 1 1 1
0 1 1 1 2 2
0 1 0 0 1 0

 */
public class MaximalSquare {

    public static void main(String args[]){
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));

    }

    public static int maximalSquare(char[][] matrix) {
        int len = matrix.length;
        int len1 = matrix[0].length;

        if(len1 == 0 || len == 0 || matrix == null) return 0;
        int[][] dp = new int[len + 1][len1 + 1];
        int max = 0;
        for(int i = 1;i<= len;i++){
            for(int j = 1;j<= len1;j++){
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}
