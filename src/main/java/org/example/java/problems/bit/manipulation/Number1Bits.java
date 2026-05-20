package org.example.java.problems.bit.manipulation;
/*
191. Number of 1 Bits
Find the number of bits in a number which are set to 1.

13 -> 1101 -> 3
Solution :
n >> 1 -> gives the last digit
(n >> i) & 1 -> return 1 if the last digit is 1

 */
public class Number1Bits {

    public static void main(String args[]){

        System.out.print(hammingWeight(13));
    }

    public static int hammingWeight(int n) {
        int number = 0;
        for(int i =0;i<32;i++){
            if(((n >> i) & 1) ==1){
                number++;
            }

        }
        return number;
    }
}
