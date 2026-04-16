package org.example.java.problems.matrix;
/*
74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.


 */
public class SearchMatrix {

    public static void main(String args[]){
        int[][] m = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(m,17));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i =0;i< n;i++){
            if(matrix[i][0] <= target && matrix[i][m-1] >= target){
                int t = m-1;
                while(t >= 0){
                    if(matrix[i][t] == target)
                    {
                        return true;
                    }
                    else{
                        t--;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
