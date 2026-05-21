package org.example.java.problems.bit.manipulation;
/*
201. Bitwise AND of Numbers Range
As numbers increase in a range, the lower bits keep changing.

Only the common leftmost prefix bits remain unchanged.
5  = 101
6  = 110
7  = 111
Common prefix = 1
Remaining bits become 0.
Result = 100

Reduce the number to become same in the left by shifting right. Deleting last digits until equal
Then add 0s to the right by shifting left.
 */
public class BitwiseAndRange {

    public static void main(String args[]){

    System.out.println(rangeBitwiseAnd(5,7));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int result;
        if(left == 0) return 0;
        int count =0;
        while(left < right){
            left = left >> 1;
            right = right >> 1;
              count++;
        }

        result = left  << count;
        return result;
    }
}
