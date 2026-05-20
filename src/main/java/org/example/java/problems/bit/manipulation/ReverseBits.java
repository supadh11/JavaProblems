package org.example.java.problems.bit.manipulation;
/*
190. Reverse Bits

Reverse bits of a given 32 bits signed integer.
Input: n = 43261596
Output: 964176192
00000010100101000001111010011100  transforms to
00111001011110000010100101000000
Solution :

rev << 1        :     Moves existing bits left.
((n >> i) & 1)  :     Give me the i-th bit of n. First shift to ith bit and then return the bit using & operation.
(rev << 1) | ((n >> i) & 1)  : Shift rev left by one position to make space,
                                extract the i-th bit from n, and append that bit to the end of rev.
 */
public class ReverseBits {

    public static void main(String args[]){

    System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int rev = 0;
        for(int i =0;i<32;i++){
            rev = (rev << 1) | ((n >> i) & 1);
        }
        return rev;
    }
}
