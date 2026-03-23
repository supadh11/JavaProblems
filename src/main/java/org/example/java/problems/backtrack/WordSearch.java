package org.example.java.problems.backtrack;
/*
79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Solution :
1) Call backtrack method inside a loop of i,j where they are the length and breadth of grid
2) our goal is to reach to the length of the word , if we reached return true
3) Return false  when -> i,j exceeds board length/breadth or goes negative
                      -> board[i][j] != word.charAt(wordIndex)
                      -> wordIndex >= length of word
4) assign random char to covered word, so as to not come back to it again
5) calculate exists by calling backtrack in all four directions
6) reassign the value of covered word
7) return exists

 */
public class WordSearch {

    public static void main(String args[]){
    char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F','C', 'S'}, {'A', 'D', 'E', 'E'}};

      System.out.println(  exist(board,"ABCCEDAS"));

    }

    public static boolean exist(char[][] board, String word) {

        for(int i =0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
               if( backtrack(board,word, i,j  ,0)) return true;
            }
        }


        return false;
    }

    private static boolean backtrack(char[][] board, String word, int i, int j, int wordIndex) {
        if(wordIndex == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;
        if(wordIndex >= word.length()) return false;
        if(board[i][j] != word.charAt(wordIndex)) return false;
        board[i][j] = '*';
        boolean exist = (backtrack(board,word,i+1,j,wordIndex+1) ||
                backtrack(board,word,i,j+1,wordIndex+1) ||
        backtrack(board,word,i-1,j,wordIndex+1) ||
        backtrack(board,word,i,j-1,wordIndex+1));

        board[i][j]=word.charAt(wordIndex);

        return exist;

    }
}
