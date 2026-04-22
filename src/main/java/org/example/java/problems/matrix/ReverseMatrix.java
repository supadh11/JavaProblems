package org.example.java.problems.matrix;

import java.util.Arrays;

/*

48. Rotate Image
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Simple solution is to first rotate through diagonal and then swap columns in rows

1,2,3,  ->  1, 4, 7  ->    7, 4, 1
4,5,6,      2, 5, 8        8, 5, 2
7,8,9,      3, 6, 9        9, 6, 3

 */
public class ReverseMatrix
{

    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Arrays.stream(matrix).forEach(a ->{
            Arrays.stream(a).forEach(ele -> {
                System.out.print(ele+",");
            });
            System.out.println();
        });
        rotate(matrix);
        Arrays.stream(matrix).forEach(a ->{
            Arrays.stream(a).forEach(ele -> {
                System.out.print(ele+",");
            });
            System.out.println();
        });
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i =0;i<len;i++){
            for(int j = i+1;j< len;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i =0;i<len;i++){
            for(int j = 0;j< len/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = temp;
            }
        }



    }



}
