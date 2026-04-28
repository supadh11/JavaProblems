package org.example.java.problems.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(String args[]){
       //System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}}));
       // [1,2,3,4,8,12,16,20,24,23,22,21,17,13,9,5,6,7,11,15,19,18,14,10]
        //[1,2,3,4,8,12,16,20,24,23,22,21,17,13,9,5,6,7,3,2,1,5,9,13]
     //   [1, 2, 3, 4, 8, 12, 16, 20, 24, 23, 22, 21, 17, 13, 9, 5, 6, 7, 11, 15, 19, 18, 17, 13]
       //[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16],[17,18,19,20],[21,22,23,24]]

       // System.out.println(spiralOrder(new int[][]{{1,12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int i = matrix[0].length;
        int j = matrix.length;
        List<Integer> returnList = new ArrayList<>();
        int right =0;
        int down=0;
        int left = 0;
        int up =0;
        boolean rightCount = true;
        boolean downCount = true;
        boolean direction = true;
        int count =1;
        while(returnList.size() < (matrix.length * matrix[0].length)){
            if(down >-1 && down < matrix.length &&
                    right > -1 && right < matrix[0].length) returnList.add(matrix[down][right]);
            if(count == ((2*i + 2*j)-4)){
                direction = true;
                rightCount= true;

                i--;
                j--;
                left++;
                up++;
            }
            if(direction  && matrix[0].length != 1){
                if(rightCount) {
                    right++;

                }else{
                    right--;

                }
                if(right >= (i-1) || right <= left){
                    direction = !direction;
                    rightCount = !rightCount;
                }
            }else {
                if(downCount) {
                    down++;
                }else{
                    down--;
                }
                if(down >= (j-1) || down <= up){
                    direction = !direction;
                    downCount = !downCount;
                }
            }

            count++;
        }

        return returnList;
    }


}
