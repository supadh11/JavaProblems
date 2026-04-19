package org.example.java.problems.misc;
/*

69. Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Solution :
A better solution is to o binary search by taking left+right/2 and finding the square, if value is greater move the left -1
and if it is less than value move right +1 .

 */
public class Sqrt {

    public static void main(String args[]){
        System.out.println(mySqrt(45763545));
    }

    public static int mySqrt(int x) {

        if(x == 0) return 0;
        if(x == 1) return 1;
        for(int i =2 ;i<=x/2;i++){
            long val = (long)i * (long)i;
            long val2 = (long)(i+1) * (long)(i+1);
            if(val <= x && (val2) > x){
                return i;
            }
        }

        return 1;


    }
}
