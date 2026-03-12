package org.example.java.problems.strings;
/*
38. Count and Say
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.
 */
public class CountAndSay {

    public static void main(String args[]){
        int n = 6;
        System.out.println(rle(n));
    }

    private static String rle(int n) {
        String val = "1";
        String sb = "";
        for(int i=0;i<n-1;i++){

            int count = 1;

            for(int j =1;j<val.length();j++){

                if((val.charAt(j)) == val.charAt(j-1) ){
                    count++;
                }else{
                    sb = sb+count+val.charAt(j-1);
                    count = 1;
                }

            }
            val = sb +(count)+val.charAt(val.length()-1);
            sb="";

        }
        return val;
    }
}
