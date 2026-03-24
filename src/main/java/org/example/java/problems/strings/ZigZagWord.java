package org.example.java.problems.strings;
/*
6. Zigzag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Solution :

int cycleLen = 2 * numRows - 2;
for (int row = 0; row < numRows; row++) {
        for (int j = 0; j + row < s.length(); j += cycleLen) {

            // vertical element
            result.append(s.charAt(j + row));

            // diagonal element (for middle rows only)
            if (row != 0 && row != numRows - 1
                && j + cycleLen - row < s.length()) {
                result.append(s.charAt(j + cycleLen - row));
            }
        }
    }
 */
public class ZigZagWord {
    public static void main(String args[]){
        System.out.print(convert("AB",1));
    }
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        if(numRows > s.length()){
            return s;
        }
        int width = s.length();
        char[][] charArray = new char[numRows][width];

        char[] array = s.toCharArray();
        int row=0,col = 0;
        boolean zig = true;
        boolean zag = false;
        for(int i =0;i<s.length();i++){
            charArray[row][col] = array[i];
            if(zig){
                row++;
            }else if(zag){
                row--;
                col++;
            }
            if(row == numRows-1){
                zig = false;
                zag = true;
            }else if ( row == 0){
                zig = true;
                zag = false;
            }
        }
        StringBuffer sb = new StringBuffer("");
        for(int i =0;i<charArray.length;i++){
            for(int j =0;j<charArray[i].length;j++){
                if((charArray[i][j]) != 0){
                    sb.append(charArray[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
