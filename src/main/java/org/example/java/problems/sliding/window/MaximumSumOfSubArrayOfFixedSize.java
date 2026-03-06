package org.example.java.problems.sliding.window;

public class MaximumSumOfSubArrayOfFixedSize {

        public static void main(String args[]){
            int[] arr = {1,2,4,7,8,10,6,3,11,0,1};

            int size = 4;
            int maxSum = 0;
            int sum = 0;
            for (int i =0;i<size;i++){
                sum  = sum + arr[i];
                maxSum = sum;
            }

            for (int i = 1; i<= arr.length-size;i++){
                sum = sum - arr[i-1] + arr[i+size-1];
                System.out.println(sum);
                maxSum =  Math.max(sum, maxSum);
            }

            System.out.println(maxSum);
        }
    }
