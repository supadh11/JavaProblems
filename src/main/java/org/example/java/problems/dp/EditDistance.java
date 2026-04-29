package org.example.java.problems.dp;
/*
72. Edit Distance
Interpretation:

Insert → add a char to word1 → move right
Delete → remove char → move down
Replace → change char → move diagonally

Moving right → inserting
Moving down → deleting
Moving diagonal → replacing or matching

consider cost as minimum of diagonal,up, left

|    | "" | c | u | t |
| -- | -- | - | - | - |
| "" | 0  | 1 | 2 | 3 |
| c  | 1  | 0 | 1 | 2 |
| a  | 2  | 1 | 1 | 2 |
| t  | 3  | 2 | 2 | 1 |

      "" e x e c u t i o n
""    0  1 2 3 4 5 6 7 8 9
i     1  1 2 3 4 5 6 6 7 8
n     2  2 2 3 4 5 6 7 7 7
t     3  3 3 3 4 5 5 6 7 8
e     4  3 4 3 4 5 6 6 7 8
n     5  4 4 4 4 5 6 7 7 7
t     6  5 5 5 5 5 5 6 7 8
i     7  6 6 6 6 6 6 5 6 7
o     8  7 7 7 7 7 7 6 5 6
n     9  8 8 8 8 8 8 7 6 5
 */
public class EditDistance {

    public static void main(String args[]){
        System.out.println(minDistance("test", "resti"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] matrix = new int[len1+1][len2+1];
        for(int i =0;i<=len1;i++){
            matrix[i][0] = i;
        }
        for(int j=0;j<=len2;j++){
            matrix[0][j] = j;
        }

        for(int i=0;i<len1;i++){

            for(int j = 0;j<len2;j++){

                if(word1.charAt(i) == word2.charAt(j)){
                    matrix[i+1][j+1] = matrix[i][j];
                }else{
                    int add = matrix[i][j+1];
                    int delete = matrix[i+1][j];
                    int rep = matrix[i][j];
                    matrix[i+1][j+1] = Math.min(Math.min(add,delete),rep)+1;
                }
            }
        }
        return matrix[len1][len2];
    }
}
