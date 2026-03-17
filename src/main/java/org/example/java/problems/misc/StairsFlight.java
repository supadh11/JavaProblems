package org.example.java.problems.misc;

public class StairsFlight {

    public static void main(String args[]){
        System.out.println(climbStairs(8));
    }

    private static int climbStairs(int n){
        int sum1 = 1;
        int sum2 = 0;
        int temp = 0;

        for(int i =0;i<n;i++){
            temp = sum2;
            sum2 = sum1+sum2;
            sum1 = temp;


        }

        return sum2;


    }

    private static int findSum(int sum, int n) {
        if(n==1){
            return sum;
        }else{
            n--;
            return sum+findSum(sum,n);
        }

    }

}
