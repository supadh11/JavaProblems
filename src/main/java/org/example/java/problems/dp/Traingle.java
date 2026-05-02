package org.example.java.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
120. Triangle
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row,
you may move to either index i or index i + 1 on the next row.

Solution : just use bottom-up approach.keep on adding the minimum of previous rows j,j+1 elements to the actual rows and return 0,0
 */
public class Traingle {

    public static void main(String args[]){
        List<Integer> a1= Arrays.asList(2);
        List<Integer> a2= Arrays.asList(3,4);
        List<Integer> a3= Arrays.asList(6,5,7);
        List<Integer> a4= Arrays.asList(4,1,8,3);
        List<List<Integer>> root = Arrays.asList(a1,a2,a3,a4);

        System.out.println(minimumTotal(root));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-1;i>0;i--){
            List<Integer> prevRow =  triangle.get(i);
            List<Integer> row = triangle.get(i-1);
            for(int j = 0;j<row.size();j++){

                int minVal = Math.min((prevRow.get(j+1)+row.get(j)),(prevRow.get(j)+row.get(j)));
                row.set(j, minVal);
            }
        }
        return triangle.get(0).get(0);
    }



}
