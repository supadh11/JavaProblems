package org.example.java.problems.misc;
/*
50. Pow(x, n)
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Solution : use recursion to solve the issue in log n time. just take care of the long Integer.Min_VALUE when converted to positive value will give
overflow error, so use it to cast to long first, which can be again converted to int.

 */
public class Power {

    public static void main(String args[]){

        System.out.print( (double)myPow(2.100d,21));
    }

    public static double myPow(double x, int n) {

        if(n == 0){
            return 1d;
        }else{

            long na = n;
            if(na < 0){
                 na = (long) -1 * n;
                x = 1/x;
            }else{
                na = n;
            }

            return n%2 == 0 ? myPow(x*x, (int) (na/2)):x*myPow(x*x, (int) (na/2));
        }
    }
}
