package org.example.java.problems.dp;
/*
64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Solution : Fill the first row and column with the sum of their path by adding the previous values in it.
in another i * j loop fill all the other cells by adding the Math.min(val[i-1][j], val[i][j-1]) to the cell value
return the value of val[width-1][length-1]

 */
public class MinimumPathSum {
    public static void main(String args[]){
       // int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPath(grid));
    }

    public static int minPath(int[][] grid){

        for(int i =1;i<grid.length;i++){
            grid[i][0] = grid[i-1][0]+grid[i][0];
        }
        for(int i =1;i<grid[0].length;i++){

            grid[0][i] = grid[0][i-1]+grid[0][i];
        }

        for(int i = 1;i < grid.length;i++){
            for(int j = 1;j<grid[i].length;j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        int i = grid.length;
        int j = grid[i-1].length;
        return grid[i-1][j-1];
    }
}
